package org.xiaohuadev.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        //1.接收请求参数
        //无论前端是什么请求方法 只要携带的参数是键值对参数 就可以获取到值
        String username = request.getParameter("username");

        //2.处理业务
        String info = "?";
        if ("atguigu".equals(username)) {
            info = "NO";
        } else info = "OK";

        //3.将要响应的数据写入response
        PrintWriter writer = response.getWriter();
        writer.write(info);
    }
}
