package com.stackroute.SalonOwnerService.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;

import java.io.IOException;

public class SalonFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods" ,"POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Credentials" ,"true");
        response.setHeader("Access-Control-Request-Headers","*");
        if(request.getMethod().equals(HttpMethod.OPTIONS.name())){
            filterChain.doFilter(request,response);
        }
        else {
            String authHeader = request.getHeader("Authorization");
            if((authHeader==null )||(! authHeader.startsWith("Bearer"))){
                throw new ServletException("JWT Token is Missing");
            }
            String myToken = authHeader.substring(7);
            System.out.println(myToken);
        }
        filterChain.doFilter(request,response);
    }
}
