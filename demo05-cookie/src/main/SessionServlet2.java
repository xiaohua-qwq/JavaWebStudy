package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/SessionServlet2"}
)
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String message = "从session中获取到用户名: " + session.getAttribute("username") + "是否为新session: " + session.isNew();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(message);
    }
}
