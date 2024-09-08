package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class LoggingFilter implements Filter {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String logInfo = requestURI + "在" + dateTime + "被访问了";
        System.out.println(logInfo);

        Long t1 = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse); //放行
        Long t2 = System.currentTimeMillis();
        System.out.println(requestURI + "在" + dateTime + "执行完毕 耗时" + (t2 - t1) + "毫秒");
    }
}
