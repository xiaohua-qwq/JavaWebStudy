package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/SessionServlet"}
)
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();

        session.setMaxInactiveInterval(120); //设置session存活时间

        System.out.println(session.getId());
        System.out.println(session.isNew());

        session.setAttribute("username", username);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("成功");
    }
}
