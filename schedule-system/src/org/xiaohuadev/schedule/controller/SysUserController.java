package org.xiaohuadev.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.xiaohuadev.schedule.pojo.SysUser;
import org.xiaohuadev.schedule.service.SysUserService;
import org.xiaohuadev.schedule.service.impl.SysUserServiceImpl;
import org.xiaohuadev.schedule.util.MD5Util;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/user/*"}
)
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userPwd = request.getParameter("userPwd");
        SysUser loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            resp.sendRedirect("/loginUserPwdError.html");
        }
        resp.sendRedirect("/showSchedule.html");
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("userPwd");

        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setUserPwd(password);
        Integer rows = userService.regist(sysUser); //返回受影响的行数
        if (rows > 0) {
            response.sendRedirect("/registSuccess.html"); //重定向
        } else {
            response.sendRedirect("/registFail.html");
        }
    }
}
