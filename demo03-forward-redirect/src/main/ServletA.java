package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servletA",
        urlPatterns = {"/servletA"}
)
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA执行了");

        String money = request.getParameter("money");
        System.out.println("servletA获得了参数money = " + money);

        //请求转发给ServletB
        //获得请求转发器 参数为请求目标
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("servletB");
        //让请求器做出转发动作
        //requestDispatcher.forward(request, resp);

        //目标可以是Servlet动态资源 也可以是一个静态资源
        //请求转发可以访问WEB-INF下的受保护资源 这也是WEB-INF下资源的唯一访问方式
        request.getRequestDispatcher("WEB-INF/servletA.html").forward(request, resp);
    }
}
