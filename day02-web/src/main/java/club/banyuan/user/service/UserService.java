package club.banyuan.user.service;

import club.banyuan.user.module.UserVo;

import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:23 下午
 **/
public interface UserService {

    /**
     * @param userVo
     * @return 返回对象中包含数据库的自增ID
     */
    UserVo addUser(UserVo userVo);

    /**
     * @param userVo
     * @return true 添加成功，false 添加失败
     */
    UserVo updateUser(UserVo userVo);

    boolean deleteUser(UserVo userVo);

    List<UserVo> queryAllUser();

    UserVo queryUserById(int id);

}
