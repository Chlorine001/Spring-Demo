package com.example.demo.util.Encrypt;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @version 1.0
 * @Author chenglong
 * @className CustomMd5PasswordEncoder
 * @Description 自定义security密码校验
 * 关于PasswordEncoder的实现类，Spring推荐我们使用BCryptPasswordEncoder,它使用了强哈希算法
 * @Date 2025-07-23
 */

@Component
public class MyPasswordEncoder implements PasswordEncoder {

    // 这是盐推荐8字节或更大的，这是我们从源码里知道的
    final String salt = "butchersoyoung";

    @Override
    public String encode(CharSequence rawPassword) {
        // 进行一个md5加密
//        return Arrays.toString(DigestUtils.md5Digest(rawPassword.toString().getBytes()));

        try {
            // 使用JDk自带的MD5加密
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // CharSequence转为String，才能获取到字节数组，StandardCharsets.UTF_8是标准的字符集
            byte[] bytes = md5.digest((rawPassword.toString() + salt).getBytes(StandardCharsets.UTF_8));

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        // 通过md5校验
//        return encodedPassword.equals(Arrays.toString(DigestUtils.md5Digest(rawPassword.toString().getBytes())));

        // rawPassword是我们要验证的原密码 ，encodedPassword这是我们加密后的数据库中的密码
        // 这个方法并不需要我们手动调用，而是由SpringSecurity来调用，我们写好规则就可以了~

        // 这里就没有做过多的验证了，只是为了说明密码是可以自己加密的，自己定匹配规则的
        if (rawPassword != null && encodedPassword != null) {
            return encode(rawPassword).equals(encodedPassword);
        } else {
            return false;
        }

    }
}

