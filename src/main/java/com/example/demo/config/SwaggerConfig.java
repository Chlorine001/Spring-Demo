package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author chenglong
 * @className SwaggerConfig
 * @Description swagger的基础信息配置
 * @Date 2025-07-17
 */
@Configuration
@EnableSwagger2 //开启swagger2,若启动类上添加了该注解，则配置类可以不添加
//@enableSwagger2：是springfox提供的一个注解，代表swagger2相关技术开启,会扫描当前类所在包，以及子包中所有的类型中的注解，做swagger文档的定值
public class SwaggerConfig {
    //添加 Springfox 兼容性配置
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                mappings.removeIf(mapping -> mapping.getPatternParser() != null);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }


    //**每个组就是一个docket实例，多个组就是创建多个docket的实例

    // 创建swagger bean
    @Bean
    public Docket docket(Environment environment) {

        // 配置swagger的docket的bean实例
        Profiles profiles = Profiles.of("!prod");
        // 通过environment.acceptsProfiles()判断是否指定的环境中，是，则为true
        boolean flag = environment.acceptsProfiles(profiles);

        // Docket是swagger全局配置对象
        // DocumentationType：指定文档类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // swagger信息
                .apiInfo(apiInfo())
                // 配置组名
                .groupName("dev")
                // swagger 扫描包配置
                // select()获取Docket中的选择器，返回ApiSelectorBuilder构造选择器，如扫描扫描包的注解
                .select()
                /*
                  requestHandlerSelectors：请求处理选择器
                  basePackage()：扫描指定包下的所有接口
                  any()：扫描所有的包
                  none()：不扫描
                  withClassAnnotation()：扫描指定类上的注解，参数是一个注解的放射对象
                  withMethodAnnotation()：扫描方法上的注解
                 */
                // 指定扫描器扫描的规则（断言）
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                /*
                  pathSelectors：路径选择器，过滤路径
                  ang()：选择所有路径
                  none()：都不选择
                  ant()：选择指定路径
                  regex()：正则表达式
                 */
                //PathSelectors.regex("^[+-@=](.*?)")
                .paths(PathSelectors.any())
                .build()
                // 配置是否开启swagger，若为false，则浏览器不能访问
                .enable(flag);
    }

    @Bean
    public Docket docket2(Environment environment) {
        Profiles profiles = Profiles.of("demo","dev");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("docket2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build()
                .enable(flag);
    }

    // swagger文档信息
    public ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact(
                // 文档发布者的名称
                "Chlorine",
                // 文档发布者的网站地址
                "https://www.yuque.com/chlorine0816/tup",
                // 文档发布者的电子邮箱
                "1151259938@qq.com"
        );

        return new ApiInfo(
                // 标题
                "Chlorine Swagger API",
                // 文档描述
                "To be yourself!",
                // 版本号
                "1.0",
                // 服务组url地址
                "urn:tos",
                // 作者信息
                contact,
                // 开源组织
                "Apache 2.0",
                // 开源地址
                "https://www.apache.org/licenses/LICENSE-2.0",
                // 集合
                new ArrayList<>()
        );
    }
}