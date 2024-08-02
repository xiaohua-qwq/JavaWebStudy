package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servletC",
        urlPatterns = {"/servletC"}
)
public class ServletC extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //设置服务器以UTF-8编码
        response.setCharacterEncoding("UTF-8");
        //设置Content-Type响应头 告诉客户端用UTF-8进行解码
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("你好"); //向客户端响应一些文字
    }
}
