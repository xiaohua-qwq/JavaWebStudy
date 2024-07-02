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
            info = "<h1>NO</h1>";
        } else info = "<h1>YES</h1>";

        //3.将要响应的数据写入response
        //还应该设置Content-Type响应头
        //response.setHeader("Content-Type","text/html");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.write(info);
    }
}
