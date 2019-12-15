package club.banyuan.bmDemo.servlet;

import club.banyuan.bmDemo.service.UserService;
import club.banyuan.bmDemo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
@WebServlet("/delUser")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream(),
                StandardCharsets.UTF_8));
        String target = reader.readLine();
        System.out.println(target);


        JSONObject obj = JSON.parseObject(target);
        String input = obj.getString("userid");
        System.out.println(input);
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteUser(input);

        //3.跳转到查询所有Servlet
        resp.sendRedirect("users.html");
    }
}
