package com.stackroute.AuthenticationService.Filter;

import java.io.IOException;



        import io.jsonwebtoken.Jwts;

        import java.io.IOException;
        import javax.servlet.FilterChain;
        import javax.servlet.GenericFilter;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
public class filter extends GenericFilter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        String token=httpRequest.getHeader("Authorization");

        if(token==null || !token.startsWith("Bearer"))
        {
            throw new ServletException();
        }
        else
        {
            String jwtToken=token.substring(7);
            String email= Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwtToken).getBody().getSubject();
            request.setAttribute(email, email);
            chain.doFilter(request, response);
        }


    }
}