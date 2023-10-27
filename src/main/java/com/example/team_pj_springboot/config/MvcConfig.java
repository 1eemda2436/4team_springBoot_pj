package com.example.team_pj_springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry .addResourceHandler("/resources/**")
	 * .addResourceLocations("/resources/"); }
	 */
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/myimage/**").addResourceLocations("classpath:/static/img/");
//            registry.addResourceHandler("/myimage/**").addResourceLocations("classpath:/../webapp/resources/upload/");
    }
}
