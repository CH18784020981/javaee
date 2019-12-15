package club.banyuan.bmDemo.servlet;

import club.banyuan.bmDemo.bean.Bills;
import club.banyuan.bmDemo.bean.Supplier;
import club.banyuan.bmDemo.service.UserService;
import club.banyuan.bmDemo.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
@WebServlet("/addSup")
public class AddSupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Supplier sup = new Supplier ();
        try {
            BeanUtils.populate(sup, map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //4.调用Service保存
        UserService service = new UserServiceImpl();
        service.addSup(sup);
        response.sendRedirect("users.html");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
