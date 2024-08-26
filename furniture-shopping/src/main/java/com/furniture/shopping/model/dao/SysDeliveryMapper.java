package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.SysDelivery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDeliveryMapper {
    int deleteByPrimaryKey(Long delId);

    int insert(SysDelivery record);

    int insertSelective(SysDelivery record);

    SysDelivery selectByPrimaryKey(Long delId);

    int updateByPrimaryKeySelective(SysDelivery record);

    int updateByPrimaryKey(SysDelivery record);

    List<SysDelivery> selectByUserNo(String userNo);
}