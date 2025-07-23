package com.example.demo.util.Encrypt;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Lianhong
 * @since 2021/6/9
 */
public class SecurityUtil {
    private static final String ALGORITHM_3DES = "DESede";
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public SecurityUtil() {
    }

    public static byte[] encrypt3DES(String encryptPassword, byte[] encryptByte) {
        try {
            Cipher cipher = init3DES(encryptPassword, 1);
            return cipher.doFinal(encryptByte);
        } catch (Exception var4) {
            return null;
        }
    }

    public static String encrypt3DES(String encryptPassword, String encryptStr) {
        try {
            Cipher cipher = init3DES(encryptPassword, 1);
            byte[] enBytes = cipher.doFinal(encryptStr.getBytes(DEFAULT_CHARSET));
            return Base64.encodeBase64String(enBytes);
        } catch (Exception var4) {
            return null;
        }
    }

    public static byte[] decrypt3DES(String decryptPassword, byte[] decryptByte) {
        try {
            Cipher cipher = init3DES(decryptPassword, 2);
            return cipher.doFinal(decryptByte);
        } catch (Exception var4) {
            return null;
        }
    }

    public static String decrypt3DES(String decryptPassword, String decryptString) {
        try {
            Cipher cipher = init3DES(decryptPassword, 2);
            byte[] deBytes = cipher.doFinal(Base64.decodeBase64(decryptString.getBytes(DEFAULT_CHARSET)));
            return new String(deBytes, DEFAULT_CHARSET);
        } catch (Exception var4) {
            return null;
        }
    }

    private static Cipher init3DES(String decryptPassword, int cipherMode) throws Exception {
        SecretKey deskey = new SecretKeySpec(decryptPassword.getBytes(), "DESede");
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(cipherMode, deskey);
        return cipher;
    }
}
