package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servlet1",
        urlPatterns = {"/servlet1"}
)
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet1执行重定向");

        //设置响应状态码为302 同时设置响应头为Servlet2
        //response.setStatus(302);
        //response.setHeader("Location","servlet2");
        response.sendRedirect("servlet2");
    }
}
