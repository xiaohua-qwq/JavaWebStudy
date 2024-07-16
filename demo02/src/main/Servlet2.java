package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "responseTest",
        urlPatterns = {"/response"}
)
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //设置响应行相关API 200/404/405/500/...
        response.setStatus(200);

        //设置响应头相关API
        //response.setHeader("Content-Type", "text/html"); //设置客户端接收响应的方式
        //response.setHeader("Content-Length", "100"); //告诉客户端响应的长度以便客户端确认收到的数据是否完整
        response.setHeader("ServerCodeBy", "XiaoHua"); //也可以自定义标头
        String info = "<h1>你好世界</h1>";
        response.setContentType("text/html");
        response.setContentLength(info.getBytes().length);

        //设置响应体相关API
        PrintWriter writer = response.getWriter();
        writer.print(info); //给前端响应的信息
    }
}
