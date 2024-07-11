package org.xiaohuadev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/resp")
public class ServletResponse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //行相关  GET/POST  URI  HTTP/1.1
        System.out.println(request.getMethod()); //获取请求方式
        System.out.println(request.getScheme()); //获取获取请求协议
        System.out.println(request.getProtocol()); //获取请求协议及版本
        System.out.println(request.getRequestURI()); //获取请求的uri 指项目内的资源地址
        System.out.println(request.getRequestURL()); //获取请求的url 指完整的项目资源地址
        /*
        * URI统一资源标识符: /sys/resp
        * URL统一资源定位符: http://localhost:8080/sys/resp
        * */

        //头相关  key:value key:value ...
        String accept = request.getHeader("Accept"); //根据请求头的key获取请求头的值
        System.out.println("Accept: "+accept);
        //获取本次请求中所有请求头的名字
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName+": "+request.getHeader(headerName));
        }

        //体相关
    }
}
