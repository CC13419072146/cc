package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}