package club.banyuan.servlet.exception;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ExcepHandler")
public class ExceptionHandlerServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
        resp.setContentType("text/html;charset=GB2312");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>错误页面</title></head>");
        out.println("<body>");

        out.println("应用程序运行出错。");
        out.println("<p>错误原因：服务器端文件可能被删除。请<a href=mailto:admin@sunxin.org>报告管理员</a>。");

        out.println("</body></html>");
        out.close();
    }
}