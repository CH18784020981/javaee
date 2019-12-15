package club.banyuan.bmDemo.servlet;

import club.banyuan.bmDemo.bean.Users;
import club.banyuan.bmDemo.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import club.banyuan.bmDemo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
@WebServlet("/adddiv")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Users user = new Users();
        try {
            BeanUtils.populate(user, map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //4.调用Service保存
        UserService service = new UserServiceImpl();
        service.addUser(user);
        System.out.println("+=============》" + user);
        response.sendRedirect("users.html");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
