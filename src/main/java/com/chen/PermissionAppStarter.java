package com.chen;

import com.chen.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.chen.*.mapper")    // 扫描mapper接口
@ServletComponentScan("com.chen.listener")  // 扫描监听器
public class PermissionAppStarter implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PermissionAppStarter.class, args);
    }

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") // 要拦截的请求
                .excludePathPatterns("/login","logout");  // 放行的请求资源
    }
}
