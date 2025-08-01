//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @version 1.0
// * @Author chenglong
// * @className MyWebSecurityConfigurerAdapter
// * @Description 在SpringBoot2.7及以上版本中，WebSecurityConfigurerAdapter类已过期。配置过滤器链和WebSecurity需分别通过自定义SecurityFilterChainBean和WebSecurityCustomizerBean实现。
// * configure(HttpSecurity)：主要是配置Spring Security中的过滤器链；
// * configure(WebSecurity)：主要是配置一些路径放行规则。
// * @Date 2025-07-25
// */
//
//@Configuration
//public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
////        http.authorizeRequests()
////                .antMatchers(
////                        "/api-docs/**",
////                        "/doc/**",
////                        "/webjars/**",
////                        "/doc.html"
////                ).permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        String password = passwordEncoder.encode("123456");
////        auth.inMemoryAuthentication().withUser("tom").password(password).roles("admin");
//        auth.userDetailsService(userDetailsService)//配置 UserDetailsService 实现类，实现自定义登录校验
//                .passwordEncoder(passwordEncoder);  //配置密码加密规则
//    }
//
//}
