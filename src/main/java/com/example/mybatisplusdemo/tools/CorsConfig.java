package com.example.mybatisplusdemo.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Value("${cors.allowed-origins}")
  private String allowedOrigins;
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")  // 所有接口允许跨域
        .allowedOrigins(allowedOrigins)  // 前端地址
        .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许请求方法
        .allowedHeaders("*")  // 允许所有请求头
        .allowCredentials(true)  // 允许携带 Cookie
        .maxAge(3600);  // 预检请求缓存时间（秒）
  }
}
