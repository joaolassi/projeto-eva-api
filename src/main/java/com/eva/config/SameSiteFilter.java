package com.eva.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class SameSiteFilter extends GenericFilterBean {
    @Override
    public void doFilter (ServletRequest request,  ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Set-Cookie", "SameSite=None; Secure;");
        resp.setHeader("Set-Cookie", "Secure;");
        chain.doFilter(request, response);
    }
}
