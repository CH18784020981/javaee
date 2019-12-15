package club.banyuan.dao;

import club.banyuan.module.User;

import java.sql.*;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/2 4:21 下午
 **/
public class UserDao {
    public User getUserByName(String username) throws ClassNotFoundException, SQLException {
        Connection conn = ConnManager.getConnection();

        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM user_info WHERE username=?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        User user = new User();
        user.setId(rs.getString(0));
        user.setUsername(rs.getString(1));
        user.setPassword(rs.getString(2));
        ConnManager.closeConn(stmt, conn);
        return user;
    }

    public boolean addUser(User user) throws Exception {
        Connection conn = ConnManager.getConnection();

        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(
                "INSERT INTO user_info (username, password) VALUES(?,?)");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        boolean rlt = stmt.executeUpdate() > 0;

        ConnManager.closeConn(stmt, conn);
        return rlt;
    }

}
