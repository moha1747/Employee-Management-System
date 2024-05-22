package com.example.employeemanagmentbackend.middleware;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * A filter that adds a custom header to the response for requests matching a specific pattern.
 */
@Component
public class MainFilter extends OncePerRequestFilter {

    /**
     * Adds a custom header to the response and continues the filter chain.
     *
     * @param request the HTTP request.
     * @param response the HTTP response.
     * @param filterChain the filter chain.
     * @throws ServletException if an error occurs during the filter chain processing.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Example of adding a header to the response
        response.addHeader("X-Example-Header", "Value");

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

}
