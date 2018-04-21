package ru.sberbank.socialnetwork.webui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.sberbank.socialnetwork.webui.interceptors.AddUserInfoToModelInterceptor;
import ru.sberbank.socialnetwork.webui.interceptors.AuthCheckInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public AuthCheckInterceptor authCheckInterceptor() {
        return new AuthCheckInterceptor();
    }

    @Bean
    public AddUserInfoToModelInterceptor addUserInfoToModelInterceptor() {
        return new AddUserInfoToModelInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/signup", "/", "/index");
        registry.addInterceptor(addUserInfoToModelInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/signup", "/", "/index");
    }

}