package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

/**
 * @version 1.0
 * @Author chenglong
 * @className SecurityConfig
 * @Description
 * @Date 2025-07-22
 */
@Configuration
@EnableWebSecurity //是开启SpringSecurity的默认行为
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/api-docs/**", "/doc.html", "/webjars/**")
//                .permitAll();
//        return http.build();
        return  http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登录接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                // 静态资源，可匿名访问
                .antMatchers(HttpMethod.GET, "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**").permitAll()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**","/doc.html").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // cors security 解决方案
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .build();
    }

    /**
     * 密码明文加密方式配置
     * @return
     * 密码加密，必须为 @Bean ，否则报错
     *     作用：实例化密码加密规则，该规则首先会校验数据库中存储的密码是否符合其规则（经过 BCryptPasswordEncoder 加密的密码
     * 的字符串符合一定的规则）：
     *     1.若不符合，直接报错；
     *     2.若符合，则会将前端传递的密码经过 BCryptPasswordEncoder 加密，再和数据库中的密码进行比对，一样则通过
     *     所以，这里要求，我们存入进数据库的密码不能是明文，而必须是经过 BCryptPasswordEncoder 加密后，才能存入数据库
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new MyPasswordEncoder();
        //参数10就是strength，即密钥的迭代次数（默认为10）
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 允许跨域
                .cors()
                .and()
                // 配置路劲是否需要认证
                .authorizeRequests()
                // 对于登录接口 允许匿名访问 anonymous 仅允许匿名用户访问,如果登录了访问 反而没权限
                .antMatchers("/login").permitAll()
                // 静态资源，可匿名访问
                .antMatchers(HttpMethod.GET, "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**","/*.ico").permitAll()
                .antMatchers("/swagger-ui.html","/doc.html/**", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**","/doc.html").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().fullyAuthenticated()
                .and()
                .build();
    }

 /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * 配置跨源访问(CORS)
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}