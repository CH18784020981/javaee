package club.banyuan.servlet.exception;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/dbexcep")
public class DBExceptionServlet extends HttpServlet {

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ce) {
            throw new UnavailableException("加载数据库驱动失败！");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC", "root", "12345678");
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM user_info WHERE username = 1");
        } catch (SQLException se) {

            getServletContext().log("ServletContext.log(): 数据库操作失败！" +
                    se.toString());
            log("GenericServlet.log(): 数据库操作失败！" + se.toString());
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "数据库操作出现问题，请联系管理员。");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    log("关闭Statement失败！", se);
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    log("关闭数据库连接失败！", se);
                }
                conn = null;
            }
        }
    }
}