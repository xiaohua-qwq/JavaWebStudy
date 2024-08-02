package serlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servletA",
        urlPatterns = {"/x/y/z/servletA"}
)
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servletA");
        //response.sendRedirect("../../../servletB"); //相对路径模式
        //response.sendRedirect("/demo04/servletB"); //绝对路径模式

        //获取项目上下文路径然后再进行绝对路径拼接
        String contextPath = req.getServletContext().getContextPath();
        response.sendRedirect(contextPath + "/servletB");
    }
}
