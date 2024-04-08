package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.entity.UserMessage;
import com.test.util.DbUtil;

/**
 * 实现对user_message表进行操作的方法
 *
 * @author lzq
 */
public class UserMessageDao {
    /**
     * 向user_message表中注册新用户信息
     * @param userMessage 新的用户信息
     * @return 注册成功返回大于0的整数（注册用户的编号），否则返回0
     * @throws ClassNotFoundException 数据库驱动加载失败
     * @throws SQLException  用户注册失败
     * @author lzq
     */
    public int insert(UserMessage userMessage)throws ClassNotFoundException,SQLException {
        //声明与数据库相关的对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载数据库驱动，并获得数据库连接对象
            conn = DbUtil.getConnection();
            //创建insert语句
            String sql = "insert into user_message(user_name,user_password,user_phone,user_email,user_sex) values(?,?,?,?,?)";
            //获得准备语句对象，并设置准备语句对象将要执行的insert语句,并设置准备语句对象可以返回数据库自增长的主键
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //替换准备语句对象中的问号
            ps.setString(1,userMessage.getUserName());
            ps.setString(2,userMessage.getUserPassword());
            ps.setString(3,userMessage.getUserPhone());
            ps.setString(4,userMessage.getUserEmail());
            ps.setString(5,userMessage.getUserSex());
            //使用准备语句对象执行insert语句，并获得insert语句执行后向表中添加数据的行数
            int rows = ps.executeUpdate();
            //如果添加成功，提交事务，返回行数
            if(rows > 0) {
                conn.commit();
                //获得数据库自增长的主键，并将主键存入结果集中
                rs = ps.getGeneratedKeys();
                //将结果集的指针向下移动一行
                rs.next();
                //获得主键
                int userId = rs.getInt(1);
                //返回主键
                return userId;
            }
            //如果添加失败，回滚事务
        }
        finally {
            //关闭与数据库相关的对象
            DbUtil.close(null,ps,conn);
        }
        return 0;
    }
}
