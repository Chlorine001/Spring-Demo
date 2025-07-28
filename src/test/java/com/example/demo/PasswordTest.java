package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.Encrypt.RSAUtil;
import com.example.demo.util.Encrypt.SecurityUtil;
import com.example.demo.util.Password;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Author chenglong
 * @className Test
 * @Description
 * @Date 2025-07-28
 */
public class PasswordTest {
    public static void main(String[] args) {
        /**
         * 01 - 请求报文加签（rsa）加密（3des）示例
         */
        JSONObject content = new JSONObject();
        content.put("current", 1);
        content.put("size", 1000);
        //请求参数（外部报文）
        JSONObject pms = new JSONObject() {{
            put("signType", "RSA");
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
            put("timestamp", simple.format(new Date()));
            put("content", SecurityUtil.encrypt3DES(Password.getPassword_3des(), content.toJSONString())); //content加密
        }};
        //请求报文加签
        pms.put("sign", RSAUtil.sign(RSAUtil.getSignatureContent(pms), Password.getPrivateKeyString()));
        System.out.println(pms);

        //加密加签后的请求参数
//        {
//                "sign": "IGe0vm5WRvNOvy1dYtudtcXTnkfZ4ekUMNyOSnyJGyMHXJoMZhZLewcHVtwDomEJL2Se9K55Uj56lJgov9dYU4oNV/mnr6oqmxKKGinwsaf4nXZErMXNzFxiJTMJZixMUK57A6uckEYBjaDKkG+6ng+6WFtUDeY499fDKI=",
//                "signType": "RSA",
//                "content": "Je/6WFchWB2t2GeaOi3LI9iEPpxBXPwowmmcRjPIPGxJ9TypNym59Elqw/uIvDcjvOQ3qrnKrrMwOhKq+Jvn4q0ecj5Qszj/wDII3meq2wupvRHCvqx98vgttgZ5Rx2Ow+kUA22V/B/+2aKHjgcaux2rE6fifs=",
//                "timestamp": "2024-08-15 15:24:30"
//        }
        //加密加签完毕，开始请求 ...


        /**
         * 02 - 请求参数验签（rsa）解密（3des）示例
         */
        //获取请求参数，开始验签、解密
        String sign = pms.getString("sign");
        //加签不含sign，验签则不需要该字段
        pms.remove("sign");
        boolean verify = RSAUtil.verify(RSAUtil.getSignatureContent(pms), sign, Password.getPublicKeyString());
        System.out.println(verify);
        //验签成功，解密content
        String contentString = pms.getString("content");
        System.out.printf("decrypted content: %s", SecurityUtil.decrypt3DES(Password.getPassword_3des(), contentString));
        System.out.println();
        //验签成功、解密完成，开始执行相关业务代码


        /**
         * 03 - 响应报文验签 解密
         */
        String res ="{\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"content\": \"eRzf9e6D3CE=\",\n" +
                "\t\"message\": \"success\",\n" +
                "\t\"sign\": \"WAVyv9WFZ0tul4AEcqjLLnjvZJFR4khxQkU6WiMt/eMkuKQHUUAzOPIBARNnioX6BNAyBf+cXf1wjNqOE8icmtIrJ+UsgjgGZwPoN61cxyUugUSlcjuJgEHsO7Z7N9vqNcDYDEmJZo7r/AL+AjdzzX7WhT3MhsNvtuCQ4q8dzbo=\",\n" +
                "\t\"signType\": \"RSA\",\n" +
                "\t\"total\": 0\n" +
                "}";
        JSONObject obj = JSONObject.parseObject(res);
        String sign1 = obj.getString("sign");
        obj.remove("sign");
        boolean verify1 = RSAUtil.verify(RSAUtil.getSignatureContent(obj), sign1, Password.getQstPublicKeyString());
        System.out.println(verify1);
        System.out.printf("decrypted content: %s", SecurityUtil.decrypt3DES(Password.getPassword_3des(),RSAUtil.getSignatureContent(obj)));
    }

}
