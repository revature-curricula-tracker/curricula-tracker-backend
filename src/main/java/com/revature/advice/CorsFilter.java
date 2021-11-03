package com.revature.advice;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@WebFilter("/*")
public class CorsFilter extends OncePerRequestFilter {
	public static final String ORIGIN = "http://curricula-tracker.s3-website-us-east-1.amazonaws.com/";
	public static final String ORIGIN_NEW = "http://54.161.65.198:5000";
	
	
	
	
    @Override
    protected void doFilterInternal(final HttpServletRequest req, final HttpServletResponse resp, final FilterChain chain) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain.doFilter(req, resp);
    }
}
