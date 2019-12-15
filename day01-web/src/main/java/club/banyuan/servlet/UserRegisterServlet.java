package club.banyuan.servlet;

import club.banyuan.module.User;
import club.banyuan.service.UserService;
import club.banyuan.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/2 3:52 下午
 **/
public class UserRegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    public void init() throws ServletException {
        System.out.println("+++++++++++++++++");
        System.out.println("UserRegisterServlet init");
        System.out.println("+++++++++++++++++");
    }

    @Override
    public void destroy() {
        System.out.println("+++++++++++++++++");
        System.out.println("UserRegisterServlet destroy");
        System.out.println("+++++++++++++++++");
    }

    /**
     * 表单提交根据路径映射到此函数执行，映射路径配置在web.xml
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("userName=" + request.getParameter("username"));
        List<String> password = Arrays.asList(request.getParameterValues("password"));
        if (password.size() < 2 || !password.get(0).equals(password.get(1))) {
            response.getWriter().println("user password is not valid");
            return;
        }
        User user = new User();
        // 获取单个属性的时候使用
        user.setUsername(request.getParameter("username"));
        // 获取相同属性但是多个值的时候使用
        user.setPassword(request.getParameterValues("password")[0]);
        if (userService.isUserValid(user)) {
            if (userService.userRegister(user)) {
                // 注册成功后页面跳转
                response.sendRedirect("home.jsp");
            } else {
                response.getWriter().println("register user fail");
            }
        } else {
            response.getWriter().println("user is not valid");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        System.out.println("userName=" + request.getParameter("username"));
        User user = new User();
        // 获取单个属性的时候使用
        user.setUsername(request.getParameter("username"));

        user.setPassword(request.getParameter("password"));
        if (userService.isUserValid(user)) {
            if (userService.userRegister(user)) {
                // 登录成功后页面跳转
                response.sendRedirect("home.jsp");
            } else {
                response.getWriter().println("register user fail");
            }
        } else {
            response.getWriter().println("user is not valid");
        }
    }
}
