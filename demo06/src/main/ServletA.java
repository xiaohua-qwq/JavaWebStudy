package main;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ServletA"}
)
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域存放数据
        req.setAttribute("request","requestMessage");

        //会话域存放数据
        req.getSession().setAttribute("session","sessionMessage");

        //应用域存放数据
        ServletContext application = this.getServletContext();
        application.setAttribute("application","applicationMessage");

        String reqMessage = (String)req.getAttribute("request");
        System.out.println("请求域: "+reqMessage);

        req.getRequestDispatcher("ServletB").forward(req, resp);
    }
}
