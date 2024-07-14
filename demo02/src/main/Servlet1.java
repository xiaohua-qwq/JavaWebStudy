package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(
        name = "servlet1",
        urlPatterns = "/servlet1"
)
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //以下方式皆可以获取key=value形式的参数 无论这些参数是在URL后还是在请求体中

        System.out.println("------直接通过key获取(用户名和密码)------");
        String username = request.getParameter("username"); //根据参数名 获取键值对形式的参数值
        String password = request.getParameter("password"); //根据参数名 获取键值对形式的参数值
        System.out.println(username);
        System.out.println(password);

        //通过元素key 获取多个value 比如前端提交了多个值用的是一个key
        System.out.println("------直接通过key获取(爱好)------");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        //获取出所有的key 然后通过key获取value
        System.out.println("------取出所有的key方式------");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement(); //获取前端参数的每一个key
            String[] parameterValues = request.getParameterValues(key); //由于无法确定是否有多个值 则统一认为是多值
            if (parameterValues.length > 1) {
                System.out.println(key + ": " + Arrays.toString(parameterValues));
            } else {
                System.out.println(key + ": " + parameterValues[0]);
            }
        }

        //上面的方法也可以替换为直接获取参数Map<Key,value>集合
        System.out.println("------Map集合方式------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.print(entry.getKey() + " = ");
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println(Arrays.toString(value));
            } else {
                System.out.println(value[0]);
            }
        }
    }
}
