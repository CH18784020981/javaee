package club.banyuan.user.dao.impl;

import club.banyuan.user.dao.UserDao;
import club.banyuan.user.module.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 2:20 下午
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public UserEntity addUser(UserEntity userEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnManager.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(
                    "INSERT INTO user_info (username, age) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userEntity.getUsername());
            stmt.setInt(2, userEntity.getAge());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            userEntity.setId(rs.getInt(1));
            return userEntity;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnManager.closeConn(rs, stmt, conn);
        }

    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnManager.getConnection();
            stmt = conn.prepareStatement(
                    "update  user_info  set  username=?,age=? where id=?", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, userEntity.getUsername());
            stmt.setInt(2, userEntity.getAge());
            stmt.setInt(3, userEntity.getId());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            return userEntity;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnManager.closeConn(rs, stmt, conn);
        }
    }

    @Override
    public boolean deleteUser(UserEntity userEntity) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnManager.getConnection();
            stmt = conn.prepareStatement(
                    "delete from user_info where id=?");

            stmt.setInt(1, userEntity.getId());
            //rs.next();
            if (stmt.executeUpdate()>0){
                return true;
            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {
            ConnManager.closeConn(rs, stmt, conn);
        }
        return false;
    }

    @Override
    public List<UserEntity> queryAllUser() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnManager.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(
                    "SELECT id,username,age FROM user_info");
            rs = stmt.executeQuery();
            List<UserEntity> userEntityList = new ArrayList<>();
            while (rs.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(rs.getInt(1));
                entity.setUsername(rs.getString(2));
                entity.setAge(rs.getInt(3));
                userEntityList.add(entity);
            }
            return userEntityList;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnManager.closeConn(rs, stmt, conn);
        }
    }

}
