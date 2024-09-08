package main;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ServletB"}
)
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMessage = (String)req.getAttribute("request");
        System.out.println("请求域: "+reqMessage);

        String sessionMessage = (String)req.getSession().getAttribute("session");
        System.out.println("会话域: "+sessionMessage);

        ServletContext application = this.getServletContext();
        String applicationMessage = (String) application.getAttribute("application");
        System.out.println("应用域: "+applicationMessage);
    }
}
