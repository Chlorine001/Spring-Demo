package com.example.demo.service;

import com.example.demo.entity.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author chenglong
 * @className UserDetailsService
 * @Description 如果我们自定义了UserDetailsService.class这个类并将它放置到IOC容器里面，UserDetailsServiceAutoConfiguration默认配置就会失效
 * @Date 2025-07-31
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 假设这个MyUserDetails是我们从数据库中查出来的
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUsername("user");
        myUserDetails.setPassword("123456");
        return myUserDetails;
    }
}
