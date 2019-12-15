package club.banyuan.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author 陈浩
 * @date Created on 2019/12/13
 */
public class ListenerDemo1 implements HttpSessionBindingListener {


    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();

//        session.setAttribute("123","woshinibab");
        session.removeAttribute("123");
        System.out.println(session.getAttribute("123")+"1234567");
        //session.setAttribute("123","233");
//        System.out.println(session+"12345");
        System.out.println(123456);

    }

    public void valueUnbound(HttpSessionBindingEvent event) {
//        HttpSession session = event.getSession();
//        session.getAttribute("123");
//        System.out.println(session);

    }
}
