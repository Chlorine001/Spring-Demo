package com.example.demo.util.Encrypt;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lianhong
 * @since 2022/3/3
 */
public class RSAUtil {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public RSAUtil() {
    }

    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey.getBytes(DEFAULT_CHARSET)));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));
            byte[] signed = signature.sign();
            return Base64.encodeBase64String(signed);
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public static boolean verify(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(publicKey.getBytes(DEFAULT_CHARSET));
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));
            return signature.verify(Base64.decodeBase64(sign.getBytes(DEFAULT_CHARSET)));
        } catch (Exception var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public static String encrypt(String content, String publicKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, getPublicKey(publicKeyStr));
        byte[] enBytes = cipher.doFinal(content.getBytes(DEFAULT_CHARSET));
        return Base64.encodeBase64String(enBytes);
    }

    public static String decrypt(String content, String privateKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, getPrivateKey(privateKeyStr));
        byte[] deBytes = cipher.doFinal(Base64.decodeBase64(content.getBytes(DEFAULT_CHARSET)));
        return new String(deBytes, DEFAULT_CHARSET);
    }

    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key.getBytes(DEFAULT_CHARSET));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key.getBytes(DEFAULT_CHARSET));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static String getKeyString(Key key) {
        byte[] keyBytes = key.getEncoded();
        return Base64.encodeBase64String(keyBytes);
    }

    public static <T> String getSignatureContent(JSONObject params) {
        if (params == null) {
            return null;
        } else {
            StringBuilder content = new StringBuilder();
            List<String> keys = new ArrayList<>(params.keySet());
            Collections.sort(keys);

            for (int i = 0; i < keys.size(); ++i) {
                String key = keys.get(i);
                String value = params.getString(key);
                if (value == null) continue;
                content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
            }
            return content.toString();
        }
    }

    public static <T> String getListSignatureContent(List<JSONObject> mapList) {
        if (mapList == null) {
            return null;
        } else {
            List<String> listStr = new ArrayList<>();
            for (JSONObject item : mapList) {
                listStr.add(getSignatureContent(item));
            }
            Collections.sort(listStr);
            return listStr.toString();
        }
    }

}
