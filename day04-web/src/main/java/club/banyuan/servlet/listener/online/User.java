package club.banyuan.servlet.listener.online;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class User implements HttpSessionBindingListener {
    private String name;
    private UserList ul = UserList.getInstance();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(((User) event.getValue()).getName());

        ul.addUser(name);
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(((User) event.getValue()).getName());
        ul.removeUser(name);
    }
}