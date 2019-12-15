package club.banyuan.service;

import club.banyuan.module.User;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/2 4:16 下午
 **/
public interface UserService {

    boolean isUserValid(User user);

    boolean userRegister(User user);
}
