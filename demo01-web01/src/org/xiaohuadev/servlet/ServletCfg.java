package org.xiaohuadev.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
        name = "ServletCfg",
        urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "key1", value = "value1"),
                @WebInitParam(name = "key2", value = "value2")
        }
)
public class ServletCfg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        //通过初始化的key获取Value
        String value1 = servletConfig.getInitParameter("key1");
        System.out.println("key1 = " + value1);

        //获取所有Value
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        //initParameterNames.hasMoreElements() 判断是否有下一个元素(Boolean)
        //initParameterNames.nextElement() 取出下一个元素并向下移动游标
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            System.out.println(element + " = " + servletConfig.getInitParameter(element));
        }
    }
}
