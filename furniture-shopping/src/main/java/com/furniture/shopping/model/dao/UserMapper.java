package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateUserStatus(User record);

    int updateByPrimaryKey(User record);

    User selectByNo(String userNo);

    List<User> selectByRole(Integer roleType);

    void updateAvatar(String userNo, String avatar);

    User getUser(User user);
}