package club.banyuan.user.servlet;

import club.banyuan.user.module.UserEntity;
import club.banyuan.user.module.UserVo;
import club.banyuan.user.service.UserService;
import club.banyuan.user.service.impl.UserServiceImpl;
import club.banyuan.user.util.JsonUtil;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/3 2:34 下午
 **/
public class UserAddServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            UserVo user = JsonUtil.parseReq(request, UserVo.class);
            System.out.println(user);
            UserVo rlt = userService.addUser(user);

            response.getWriter().write(JSON.toJSONString(rlt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request, response);
    }
}
