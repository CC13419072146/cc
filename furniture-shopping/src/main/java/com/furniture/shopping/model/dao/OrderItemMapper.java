package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectByOrderNo(String orderNo);

    List<OrderItem> selectByUserNo(String userNo);

    List<OrderItem> queryByUserNo(String userNo);

    List<OrderItem> selectRecord(OrderItem orderItem);

    List<OrderItem> queryCartByUserAndName(String userNo, String proName);

    void del(String userNo, String proNo);

    void cancel(String uuid);

    void updateOrder(String uuid, String orderState);

    void delete(String uuid);

    void addOrder(OrderItem oi);
}