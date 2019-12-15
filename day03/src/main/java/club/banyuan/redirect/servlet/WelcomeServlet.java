package club.banyuan.redirect.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
    private String greeting;

    public void init() {
        // 获取init参数
        greeting = getInitParameter("greeting");
        System.out.println(greeting);
        greeting = getServletConfig().getInitParameter("greeting");
        System.out.println("greeting again:" + greeting);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String welcomeInfo = greeting + ", " + username;

        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>");
        out.println("Welcome Page");
        out.println("</title></head>");
        out.println("<body>");
        out.println(welcomeInfo);
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}