package com.example.employeemanagmentbackend.middleware;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for registering filters.
 */
@Configuration
public class FilterConfig {


    /**
     * Registers the MainFilter to filter URLs matching the pattern /user/*.
     *
     * @return the FilterRegistrationBean for the MainFilter.
     */
    @Bean
    public FilterRegistrationBean<MainFilter> mainFilterRegistrationBean() {
        FilterRegistrationBean<MainFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MainFilter());
        registrationBean.addUrlPatterns("/user/*"); // Set the URL patterns to filter
        return registrationBean;
    }

}
