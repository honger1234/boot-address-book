package com.honger1234.springbootprojectseed.config;

import com.honger1234.springbootprojectseed.intercepter.TokenIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: zt
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //token拦截器
        registry.addInterceptor(tokenIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")//放行登录接口
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**","/doc.html/**","/api-docs-ext/**") //放行swagger接口文档地址
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/doc.html/**","/api-docs-ext/**") ;//放行swagger接口文档地址
                .excludePathPatterns("/test/**","/employee/list") //放行测试接口
                .excludePathPatterns("/error");//放行404异常
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * token拦截器
     * @return
     */
    @Bean
    public TokenIntercepter tokenIntercepter(){
        return new TokenIntercepter();
    }
}
