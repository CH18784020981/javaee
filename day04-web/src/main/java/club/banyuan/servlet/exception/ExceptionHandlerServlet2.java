package club.banyuan.servlet.exception;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ExcepHandler2")
public class ExceptionHandlerServlet2 extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
        resp.setContentType("text/html;charset=GB2312");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>错误页面</title></head>");
        out.println("<body>");

        String uri = (String) req.getAttribute("javax.servlet.error.request_uri");
        Object excep = req.getAttribute("javax.servlet.error.exception");
        out.println(uri + " 运行错误。");
        out.println("<p>错误原因：" + excep);

        out.println("</body></html>");
        out.close();
    }
}