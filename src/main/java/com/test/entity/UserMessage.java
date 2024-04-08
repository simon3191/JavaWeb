package com.test.entity;

import java.util.Objects;

/**
 * 用户模块实体类：当前类的一个对象可以封装user_message表中的一行用户信息
 * @author Ethereal
 */
public class UserMessage {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userSex;

    public UserMessage() {
        super();
    }

    public UserMessage(Integer userId, String userName, String userPassword, String userPhone, String userEmail,
                       String userSex) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userSex = userSex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "UserMessage [userId=" + userId + ", userName=" +
                userName + ", userPassword=" + userPassword
                + ", userPhone=" + userPhone + ", userEmail=" +
                userEmail + ", userSex=" + userSex + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserMessage other = (UserMessage) obj;
        return Objects.equals(userId, other.userId);
    }





}
