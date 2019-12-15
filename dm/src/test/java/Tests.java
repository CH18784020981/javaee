import club.banyuan.bmDemo.bean.Users;
import club.banyuan.bmDemo.dao.UserDao;
import club.banyuan.bmDemo.dao.impl.UserDaoImpl;

import java.util.List;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */

public class Tests {
    public static void main(String[] args) {
        UserDao a=new UserDaoImpl();
        List user=a.findAll();

        System.out.println(a.findAll().get(0));
    }



}
