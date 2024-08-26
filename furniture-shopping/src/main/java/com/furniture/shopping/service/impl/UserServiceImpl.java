package com.furniture.shopping.service.impl;

import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.UserMapper;
import com.furniture.shopping.model.pojo.User;
import com.furniture.shopping.service.UserService;
import com.furniture.shopping.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 用户Service实现类
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String userNo, String password, Long role){
        User user = userMapper.selectByNo(userNo);
        if (user==null){
            throw new FurnitureException(FurnitureExceptionEnum.USER_NO_EXISTS);
        }
        String md5Pass=null;
        try {
            String md5Str = MD5Utils.getMD5Str(password);
            md5Pass=md5Str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (!user.getPassword().equals(md5Pass)){
            throw new FurnitureException(FurnitureExceptionEnum.PASS_WORD_ERROR);
        }
        if (role != user.getRoleType()) {
            throw new FurnitureException(FurnitureExceptionEnum.ROLE_SEL_ERROR);
        }
        return user;
    }

    @Override
    public List<User> selectByRole(Integer roleType){
        List<User> users = userMapper.selectByRole(roleType);
        return users;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User insertUser(User user){
        int count = userMapper.insertSelective(user);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer userId){
        int count = userMapper.deleteByPrimaryKey(Long.valueOf(userId));
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user){
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserStatus(User user){
        int count = userMapper.updateUserStatus(user);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    public User selectByNo(){
        User user = userMapper.selectByNo(UserFilter.currentUser.getUserNo());
        return user;
    }

    @Override
    public User initUser(String userNo){
        User user = userMapper.selectByNo(userNo);
        return user;
    }

    @Override
    public void updateAvatar(String userNo, String avatar) {
        userMapper.updateAvatar(userNo, avatar);
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }
}
