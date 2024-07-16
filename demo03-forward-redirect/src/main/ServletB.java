package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servletB",
        urlPatterns = {"/servletB"}
)
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletB执行了");

        String money = request.getParameter("money");
        System.out.println("servletB获取到了来自ServletA的money参数 = " + money);
    }
}
