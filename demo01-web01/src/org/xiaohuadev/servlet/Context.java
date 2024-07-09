package org.xiaohuadev.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "ContextTest",
        urlPatterns = "/context"
)
public class Context extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获取项目部署路径下的某个 文件/目录 真实路径
        String uploadRealPath = servletContext.getRealPath("upload");
        System.out.println(uploadRealPath);

        //获取项目的上下文路径 即项目的访问路径 如http://localhost:8080/sys中的sys就是项目上下文路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
    }
}
