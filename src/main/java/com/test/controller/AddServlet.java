package com.test.controller;

import com.test.dao.UserMessageDao;
import com.test.entity.UserMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用当前类的doPost()方法
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获得用户在浏览器中输入的注册信息
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String userPhone = req.getParameter("userPhone");
        String userEmail = req.getParameter("userEmail");
        String userSex = req.getParameter("userSex");

        // 将注册信息封装UserMessage实体类的对象中
        UserMessage userMessage = new UserMessage(null, userName, userPassword, userPhone, userEmail, userSex);

        // 注册用户信息，并获得注册是否成功
        UserMessageDao dao = new UserMessageDao();
        try {
            int i = dao.insert(userMessage);
            // 根据注册的结果，在控制台中显示相应的信息
            //System.out.println(i > 0 ? "注册成功,您的用户编号为："+i : "注册失败");
            //注册成功时，从当前的Servlet跳转到ok.html
            //获得想要跳转的目标资源
            RequestDispatcher rd = req.getRequestDispatcher("ok.html");
            //如果目标资源存在
            if (i > 0) {
                req.getRequestDispatcher("ok.html").forward(req, resp);
                return;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //当注册失败时，从当前的Servlet重定向到error.html
        resp.sendRedirect("error.html");


    }

}
