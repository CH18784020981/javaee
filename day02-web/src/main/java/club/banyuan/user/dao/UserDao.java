package club.banyuan.user.dao;

import club.banyuan.user.module.UserEntity;

import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:35 下午
 **/
public interface UserDao {

    UserEntity addUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

    boolean deleteUser(UserEntity userEntity);

    List<UserEntity> queryAllUser();
}
