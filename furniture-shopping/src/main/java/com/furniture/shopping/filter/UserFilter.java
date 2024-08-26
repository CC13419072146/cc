package com.furniture.shopping.filter;


import com.furniture.shopping.common.Constant;
import com.furniture.shopping.model.pojo.User;
import com.furniture.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户过滤器
 */
public class UserFilter implements Filter {
    @Autowired
    private UserService userService;

    public static User currentUser=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        currentUser=(User)session.getAttribute(Constant.FURNITURE_USER);
        if (currentUser==null) {
            PrintWriter out=new HttpServletResponseWrapper((HttpServletResponse) response).getWriter();
            out.write("{\n" +
                    "    \"status\": 10007,\n" +
                    "    \"msg\": \"NEED_LOGIN\",\n" +
                    "    \"data\": null\n" +
                    "}");
            out.flush();
            out.close();
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
