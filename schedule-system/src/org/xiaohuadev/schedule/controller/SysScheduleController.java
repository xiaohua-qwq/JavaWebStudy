package org.xiaohuadev.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(
        urlPatterns = {"/schedule/*"}
)
public class SysScheduleController extends BaseController {
    protected void add(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
}
