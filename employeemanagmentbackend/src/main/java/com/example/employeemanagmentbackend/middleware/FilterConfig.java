package com.example.employeemanagmentbackend.middleware;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MainFilter> mainFilterRegistrationBean() {
        FilterRegistrationBean<MainFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MainFilter());
        registrationBean.addUrlPatterns("/user/*"); // Set the URL patterns to filter
        return registrationBean;
    }

}
