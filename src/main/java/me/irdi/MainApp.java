package me.irdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean<AuthorizationFilter> authFilterRegistration = new FilterRegistrationBean<>();
        authFilterRegistration.setFilter(new AuthorizationFilter());
        authFilterRegistration.addUrlPatterns("/library/*");
        authFilterRegistration.setOrder(2);

        return authFilterRegistration;
    }


}