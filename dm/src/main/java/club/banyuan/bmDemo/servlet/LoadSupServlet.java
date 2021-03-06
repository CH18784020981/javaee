package club.banyuan.bmDemo.servlet;

import club.banyuan.bmDemo.service.UserService;
import club.banyuan.bmDemo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
@WebServlet("/loadSup")
public class LoadSupServlet extends HttpServlet {
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
        System.out.println(service.findAllSup());
        resp.getWriter().write(JSON.toJSONString(service.findAllSup()));


    }
}
