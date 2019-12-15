package club.banyuan.bmDemo.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

import club.banyuan.bmDemo.bean.Users;
import club.banyuan.bmDemo.service.UserService;
import club.banyuan.bmDemo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;


/**
 * @author chenhao
 */
@WebServlet("/loadUsr")
public class LoadUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

//        List<Users> users = service.findAll();
//        System.out.println(users);
        System.out.println(service.findAll());
        resp.getWriter().write(JSON.toJSONString(service.findAll()));


    }
}
