package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "cookie",
        urlPatterns = {"/cookie"}
)
public class ServiceA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("key1", "你好");
        Cookie cookie2 = new Cookie("key2", "value2");

        cookie1.setMaxAge(60 * 5); //设置Cookie存储时间 单位为分钟 60*5即为五分钟
        cookie1.setPath("/s5/cookie2"); //设置Cookie提交路径

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
