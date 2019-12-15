package club.banyuan.service;

import club.banyuan.dao.UserDao;
import club.banyuan.module.User;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/2 4:18 下午
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public boolean isUserValid(User user) {
        User queryRlt = null;
        try {
            queryRlt = userDao.getUserByName(user.getUsername());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return queryRlt == null;
    }

    @Override
    public boolean userRegister(User user) {
        try {
            return userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
