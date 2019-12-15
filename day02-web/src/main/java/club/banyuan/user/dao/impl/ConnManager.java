package club.banyuan.user.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/2 5:01 下午
 **/
class ConnManager {

    static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/banyuan",
                "root",
                "Ab248625");
    }

    static void closeConn(AutoCloseable... conn) {
        if (conn != null) {
            for (AutoCloseable autoCloseable : conn) {
                if (autoCloseable != null) {
                    try {
                        autoCloseable.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
