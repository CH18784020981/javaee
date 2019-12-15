package club.banyuan;

import club.banyuan.dao.ConnManager;
import club.banyuan.module.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 陈浩
 * @date Created on 2019/12/2
 */
public class TestDemo {
    @Test

    public void getUserByName() throws ClassNotFoundException, SQLException {
        Connection conn = ConnManager.getConnection();
        String sql = "select *from user_info";
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
//            stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();
            System.out.println(rs.getString("username") + rs.getString("password"));



    }

    @Test
    public void test2() {
        System.out.println("????");
        Assert.assertTrue(false);

    }

}
