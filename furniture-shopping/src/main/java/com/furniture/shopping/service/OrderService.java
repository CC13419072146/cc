package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.MyOrder;
import com.furniture.shopping.model.pojo.Order;
import com.furniture.shopping.model.pojo.OrderItem;
import com.furniture.shopping.model.pojo.ProShop;
import com.furniture.shopping.model.vo.ResponseItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单Service
 */
public interface OrderService {
    List<Order> selectByUserNo(String userNo);

    void cancel(Long orderId);

    void delivered(Long orderId);

    void finished(Long orderId);

    @Transactional(rollbackFor = Exception.class)
    Order generatorTempOrder(String faAddress, String reAddress, String reName, String rePhone, String orderNotes);

    void generatorOrder(String faAddress, String reAddress, String reName, String rePhone, String orderNotes, String userNo);

    List<ResponseItem> selectByOrderNo(String orderNo);

    List<OrderItem> selectItemByUser(String userNo);

    void deleteItem(Long itemId);

    void addItem(OrderItem orderItem);

    List<OrderItem> selectRecord(OrderItem orderItem);

    ProShop selectByPro(String proNo);

    List<OrderItem> queryCartByUserAndName(String userNo, String proName);

    void del(String userNo, String proNo);

    void cancel(String uuid);

    void updateOrder(String uuid, String orderState);

    void delete(String uuid);

    int queryProCount(String proNo);

    void addOrder(OrderItem oi);

    int updateInventory(ProShop proShop);

    List<MyOrder> orderListAll(String userNo);

    List<MyOrder> orderListByProName(String userNo, String proName);

    void sureOrder(String uuid);
}
