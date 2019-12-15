package club.banyuan.redirect.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortalServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>");
        out.println("登录页面");
        out.println("</title></head><body>");

        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        if ("zhangsan".equals(name) && "1234".equals(pwd)) {
            // resp.sendRedirect(req.getContextPath() + "/welcome?username=zhangsan");
            resp.sendRedirect("welcome?username=zhangsan");
        } else {
            req.setAttribute("errorMsg", "登录失败，密码错误！");
            // req.getRequestDispatcher("login").forward(req, resp);
            // req.getRequestDispatcher("/login").forward(req,resp);
            // req.getServletContext().getRequestDispatcher("login").forward(req,resp);
        }
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}