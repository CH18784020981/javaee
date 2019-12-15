package club.banyuan.servlet.listener.online;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listener/onlineuser")
public class OnlineUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("user");
        String pwd = req.getParameter("password");

        if (null == name || null == pwd || name.equals("") || pwd.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (null == user || !name.equals(user.getName())) {
                user = new User(name);
                session.setAttribute("user", user);
            }

            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();

            out.println("欢迎用户<b>" + name + "</b>登录");
            UserList ul = UserList.getInstance();
            out.println("<br>当前在线的用户列表：<br>");
            List<String> nameList = ul.getUserList();
            int count = 0;
            for (int i = 0; i < nameList.size(); i++) {
                out.println(nameList.get(i));
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
                if (++i == 10) {
                    out.println("<br>");
                }
                count++;
            }

            out.println("<br>当前在线的用户数：" + count);
            out.println("<p><a href=" + req.getContextPath() +
                    "/listener/logout>退出登录</a>");
            out.close();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}