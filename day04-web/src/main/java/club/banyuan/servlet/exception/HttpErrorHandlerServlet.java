package club.banyuan.servlet.exception;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@WebServlet(urlPatterns = "/HttpErrHandler")
public class HttpErrorHandlerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Integer status_code = (Integer) req.getAttribute(ERROR_STATUS_CODE);
        out.println("<html><head><title>错误页面</title></head>");
        out.println("<body>");

        //如果你的JDK版本低于1.5，那么你应该按照如下方式调用
        //int status=status_code.intValue();
        //switch(status){...}
        switch (status_code) {
            case 401:
                break;
            case 404:
                out.println("<h2>HTTP状态代码：" + status_code + "</h2>");
                out.println("你所访问页面并不存在，或者已经被移动到其它位置。");
                out.println("<P>如有其它问题，请<a href=mailto:admin@sunxin.org>联系管理员</a>。");
                break;
            default:
                break;
        }
        out.println("</body></html>");
        out.close();
    }
}