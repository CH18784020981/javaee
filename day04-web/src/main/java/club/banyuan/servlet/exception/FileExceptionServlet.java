package club.banyuan.servlet.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/fileexcep")
public class FileExceptionServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        FileInputStream fis = new FileInputStream("config.inc");
        Properties pps = new Properties();
        pps.load(fis);

        //读取属性的代码，省略。

        fis.close();
    }
}