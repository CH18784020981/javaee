package club.banyuan.user.service.impl;

import club.banyuan.user.dao.UserDao;
import club.banyuan.user.dao.impl.UserDaoImpl;
import club.banyuan.user.module.UserEntity;
import club.banyuan.user.module.UserVo;
import club.banyuan.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:33 下午
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserVo addUser(UserVo userVo) {
        UserEntity userEntity = parseUserEntity(userVo);
        UserEntity rlt = userDao.addUser(userEntity);
        return parseUserVo(rlt);
    }

    @Override
    public UserVo updateUser(UserVo userVo) {
        UserEntity userEntity = parseUserEntity(userVo);
        UserEntity rlt = userDao.updateUser(userEntity);
        return parseUserVo(rlt);    }

    @Override
    public boolean deleteUser(UserVo userVo) {
        UserEntity userEntity = parseUserEntity(userVo);
        boolean rlt = userDao.deleteUser(userEntity);
        return rlt;
    }

    @Override
    public List<UserVo> queryAllUser() {
        List<UserEntity> userEntityList = userDao.queryAllUser();

        return userEntityList.stream().map(this::parseUserVo).collect(Collectors.toList());
    }

    @Override
    public UserVo queryUserById(int id) {
        return null;
    }

    private UserEntity parseUserEntity(UserVo userVo) {
        if (userVo == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userVo.getAge());
        userEntity.setUsername(userVo.getUsername());
        userEntity.setId(userVo.getId());
        return userEntity;
    }

    private UserVo parseUserVo(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        userVo.setAge(userEntity.getAge());
        userVo.setUsername(userEntity.getUsername());
        userVo.setId(userEntity.getId());
        return userVo;
    }
}
