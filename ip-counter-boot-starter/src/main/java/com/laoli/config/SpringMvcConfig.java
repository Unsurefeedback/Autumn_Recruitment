package com.laoli.config;

import com.laoli.configure.IPAutoConfiguration;
import com.laoli.interceptor.IpCounterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WeiHanQiang
 * @date 2024/10/07 13:32
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipCounterInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public IpCounterInterceptor ipCounterInterceptor(){
        return new IpCounterInterceptor();
    }
}
