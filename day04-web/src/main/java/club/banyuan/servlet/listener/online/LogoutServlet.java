package club.banyuan.servlet.listener.online;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/listener/logout")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        session.invalidate();

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>退出登录</title></head><body>");
        out.println(user.getName() + "，你已退出登录<br>");
        out.println("<a href=" + req.getContextPath() +
                "/login.html>重新登录</a>");
        out.println("</body></html>");
        out.close();
    }
}