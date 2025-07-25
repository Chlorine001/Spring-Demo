package com.example.demo.util;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @version 1.0
 * @Author chenglong
 * @className JWTUtils
 * @Description
 * @Date 2025-07-25
 */
public class JWTUtil {
    // TOKEN的有效期一小时（ms）
    private static final int TOKEN_TIME_OUT = 3_600;
    // 加密KEY
    private static final String TOKEN_ENCRY_KEY = "SMDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";
    // 最小刷新间隔（ms）
    private static final int REFRESH_TIME = 300;

    // 生产ID
    public static String getToken(Long id) {
        Map<String, Object> claimMaps = new HashMap<>();
        claimMaps.put("id", id);
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentTime))  //签发时间
                .setSubject("system")  //说明
                .setIssuer("chlorine") //签发者信息
                .setAudience("app")  //接收用户
                .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
                .signWith(SignatureAlgorithm.HS512, generalKey()) //加密方式
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000))  //过期时间戳
                .addClaims(claimMaps) //claim信息
                .compact();
    }

    //解析token
    public static Claims parseJwt(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(generalKey()) // 设置标识名
                    .parseClaimsJws(token)  //解析token
                    .getBody();
        } catch (ExpiredJwtException e) {//过期仍然返回claim
            claims = e.getClaims();
        }
        return claims;
    }


    /**
     * 获取hearder body信息
     *
     * @param token
     * @return
     */
    public static JwsHeader getHeaderBody(String token) {
        return Jwts.parser()
                .setSigningKey(generalKey()) // 设置标识名
                .parseClaimsJws(token).getHeader();
    }

    /**
     * 是否过期
     *
     * @param claims
     * @return -2：claim为空；-1：未过期但接近过期（大于刷新间隔）（需要刷新），0：未过期且不需刷新，1：已过期，2：未知错误；
     */
    public static int verifyToken(Claims claims) {
        if (claims == null) {
            return -2;
        }
        try {
            if (claims.getExpiration().before(new Date())) {
                return 1;
            }
            // 需要自动刷新TOKEN
            if ((claims.getExpiration().getTime() - System.currentTimeMillis()) < REFRESH_TIME * 1000) {
                return -1;
            } else {
                return 0;
            }
        } catch (ExpiredJwtException ex) {
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(TOKEN_ENCRY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
        String token = JWTUtil.getToken(1102L);
//        System.out.println(token);
        Claims claims = JWTUtil.parseJwt(token);
        //2024.10.9的一个token
//        Claims claims = JWTUtil.parseJwt("eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAA_zWLSQrDMAwA_6JzDF7kJfmNgmXiQMAgB1pK_17l0NsMw3zgnB02wJrD2gobXFsyaFsx1Kw30VcX9siJU4AFOk3YXPYFrXM-LiD3rre8ZfL1dBHVg_tFanRXNRpDmV_jf2J-zq4tfn-EHnvSgAAAAA.JIjyu9IPQE3ABX3_6YUJHfaPXDBxzCYze2T5yF7nIvOuAZyFurTi_Ii441w_0e5luoGQacyMjdWVs8xpZ7koog");
        switch (JWTUtil.verifyToken(claims)) {
            case -2:
                System.out.println("claim为空");
                break;
            case -1:
                System.out.println("未过期但接近过期（需要刷新）");
                break;
            case 0:
                System.out.println("token正常");
                System.out.println(claims.get("id"));
                break;
            case 1:
                System.out.println("token已过期");
                break;
            case 2:
                System.out.println("未知错误");
                break;
            default:
                System.out.println("未知状态");
                break;
        }
    }
}
