package club.banyuan.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author newpc
 * 前段输入要到的几天前几天后
 * 后端返回
 *
 */
@WebServlet("/testAndPostPostServlet")
public class TestGetAndPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String str = req.getParameter("date");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(str));
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formatDate = sdf.format(date);
        System.out.println(formatDate);
        System.out.println("大家好===============>");
        resp.getWriter().write(Integer.parseInt(str) + "天前的时间" + formatDate);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String str = req.getParameter("date");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +Integer.parseInt(str));
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formatDate = sdf.format(date);
        System.out.println(formatDate);
        System.out.println("大家好===============>");
        resp.getWriter().write(Integer.parseInt(str) + "天后的时间" + formatDate);
    }
}