package com.vebinar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vebinar.controller")
public class WebConfig extends WebMvcConfigurerAdapter{
    
    @Bean
    public ViewResolver getViewResolver() {
    FreeMarkerViewResolver fmvr = new FreeMarkerViewResolver();
    fmvr.setOrder(1);
    fmvr.setSuffix(".ftl");
    return fmvr;
    }
    
    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/","/WEB-INF/views/");
        return freeMarkerConfigurer;
    }
}