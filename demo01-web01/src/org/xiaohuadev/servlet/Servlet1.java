package org.xiaohuadev.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servlet1",
        urlPatterns = "/get"
)
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //从域中获取数据 因为已经知道了数据是字符串 所以可以强转
        String value = (String) servletContext.getAttribute("key");
        System.out.println("value为: "+value);
        servletContext.removeAttribute("key");
        System.out.println("已从域中删除此数据");
    }
}
