package club.banyuan.user.servlet;

import club.banyuan.user.module.UserVo;
import club.banyuan.user.service.UserService;
import club.banyuan.user.service.impl.UserServiceImpl;
import club.banyuan.user.util.JsonUtil;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:43 下午
 **/
public class UserQueryServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        UserVo userVo = JsonUtil.parseReq(request, UserVo.class);
        if (userVo == null || userVo.getId() == null) {
            response.getWriter().write(JSON.toJSONString(userService.queryAllUser()));
        } else if (userVo.getId() != null) {
            response.getWriter().write(JSON.toJSONString(userService.queryUserById(userVo.getId())));
        }

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

    }
}
