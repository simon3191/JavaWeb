package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库的工具类
 *
 * @author lzq
 */
public class DbUtil {

    // 连接数据库的URL
    private static String url = "jdbc:mysql://localhost:3306/db1112?useSSL=false&serverTimezone=UTC";
    // 数据库的用户名
    private static String name = "root";
    // 数据库的密码
    private static String password = "319190451";

    /**
     * 加载数据库驱动，并返回数据库连接对象
     *
     * @return 返回java.sql.Connection 接口类型的实例
     * @throws ClassNotFoundException 数据库驱动加载失败
     * @throws SQLException           数据库连接失败
     * @author lzq
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获得数据库连接对象
        Connection conn = DriverManager.getConnection(url, name, password);
        // 关闭数据库自动提交功能
        conn.setAutoCommit(false);
        // 返回数据库连接对象
        return conn;

    }
    /**
     *
     * @param rs 结果集
     * @param ps 语句对象或准备语句对象
     * @param conn 数据库连接对象
     * @throws SQLException 关闭与数据库相关对象失败
     * @author lzq
     */
    public static void close(ResultSet rs,Statement ps,Connection conn)throws SQLException {
        if(rs!=null) {
            rs.close();
        }
        if(ps!=null) {
            ps.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }
}
