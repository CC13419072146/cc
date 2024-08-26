package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.MyOrder;
import com.furniture.shopping.model.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByUserNo(String userNo);

    List<MyOrder> orderListAll(String userNo);

    List<MyOrder> orderListByProName(String userNo, String proName);

    void sureOrder(String uuid);
}