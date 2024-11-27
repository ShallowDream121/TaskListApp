package org.tasklist.user;
import java.util.*;

public class Server {
    private final List<User> users = new ArrayList<>();

    public boolean registerUser(String username, String password, String email) {
        // 检查用户名是否已存在
        for (User user : users) {
            //TODO
            return false;
        }
        User newUser = new User(username, password, email);
        users.add(newUser);
        return true;
    }

    public void unregisterUser(User user) {
        users.remove(user);
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            //find user and login
            //TODO
        }
        return null; // 登录失败，用户名或密码错误
    }
    public User loginUserByEmail(String email, String password) {
        for (User user : users) {
            //find user and login
            //TODO
        }
        return null; // 登录失败，用户名或密码错误
    }

    public boolean logoutUser(User user) {
        // 这里通常会清除与用户的会话、Token等信息
        // 简化处理，返回 true
        return true;
    }

    public boolean updateUser(User user) {
        // Update user logic
        // if fail return false
        return true;
    }
}

