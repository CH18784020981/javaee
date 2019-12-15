package club.banyuan.listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 陈浩
 * @date Created on 2019/12/13
 */
@WebServlet("/looServlet")
public class LooServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenerDemo1 listenerDemo1=new ListenerDemo1();

        HttpSession session = request.getSession();
        session.setAttribute("123","ayfgaukiluc");
        System.out.println(session.getAttribute("123")+"1234567");

        session.setAttribute("12",listenerDemo1);

        System.out.println(session.getAttribute("123")+"=====》");
//        HttpSession session2= request.getSession();
//        String  attribute = (String)session2.getAttribute("123");
//        System.out.println(session);
//        System.out.println(attribute);
        System.out.println(123);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
