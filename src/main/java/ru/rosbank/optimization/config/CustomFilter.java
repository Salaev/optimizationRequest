package ru.rosbank.optimization.config;


import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        try {
            ThreadLocalCustom.setContext(new Context(httpRequest.getHeader("Custom-ID")));
            chain.doFilter(request, response);
        } finally {
            ThreadLocalCustom.clearContext();
        }
    }
}
