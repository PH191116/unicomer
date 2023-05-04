package com.org.unicomer.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component("loggingFilter")
public class CustomFilter implements Filter {

    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        // initialize something
    }

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.info("Request Info : " + req);
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        // cleanup code, if necessary
    }
}