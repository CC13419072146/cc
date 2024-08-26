package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.User;

import java.util.List;

/**
 * 用户业务逻辑类
 */
public interface UserService {
    User login(String userNo, String password, Long role);

    List<User> selectByRole(Integer roleType);

    User insertUser(User user);

    void deleteUser(Integer userId);

    void updateUser(User user);

    void updateUserStatus(User user);

    User selectByNo();

    User initUser(String userNo);

    void updateAvatar(String userNo, String avatar);

    User getUser(User user);
}
