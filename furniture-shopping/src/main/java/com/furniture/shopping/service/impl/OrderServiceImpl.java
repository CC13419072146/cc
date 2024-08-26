package com.furniture.shopping.service.impl;

import com.furniture.shopping.common.Constant;
import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.OrderItemMapper;
import com.furniture.shopping.model.dao.OrderMapper;
import com.furniture.shopping.model.dao.ProShopMapper;
import com.furniture.shopping.model.pojo.MyOrder;
import com.furniture.shopping.model.pojo.Order;
import com.furniture.shopping.model.pojo.OrderItem;
import com.furniture.shopping.model.pojo.ProShop;
import com.furniture.shopping.model.vo.ResponseItem;
import com.furniture.shopping.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 订单Service实现类
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ProShopMapper proShopMapper;

    @Override
    public List<Order> selectByUserNo(String userNo){
        return orderMapper.selectByUserNo(userNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancel(Long orderId){
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (!order.getOrderState().equals(Constant.OrderType.NO_DELIVERED)){
            throw new FurnitureException(FurnitureExceptionEnum.ORDER_ERR_STATE);
        }
        order.setOrderState(Constant.OrderType.CANCELED);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delivered(Long orderId){
        Order order= orderMapper.selectByPrimaryKey(orderId);
        if (!order.getOrderState().equals(Constant.OrderType.NO_DELIVERED)){
            throw new FurnitureException(FurnitureExceptionEnum.ORDER_ERR_STATE);
        }
        order.setOrderState(Constant.OrderType.DELIVERED);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finished(Long orderId){
        Order order= orderMapper.selectByPrimaryKey(orderId);
        if (!order.getOrderState().equals(Constant.OrderType.DELIVERED)){
            throw new FurnitureException(FurnitureExceptionEnum.ORDER_ERR_STATE);
        }
        order.setOrderState(Constant.OrderType.FINISHED);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order generatorTempOrder(String faAddress, String reAddress, String reName, String rePhone, String orderNotes){
        Order order=new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setFaAddress(faAddress);
        order.setReAddress(reAddress);
        order.setReName(reName);
        order.setRePhone(Long.valueOf(rePhone));
        order.setSumPrice(BigDecimal.ZERO);
        order.setOrderState(Constant.OrderType.CURRENT);
        order.setUserNo(UserFilter.currentUser.getUserNo());
        int count = orderMapper.insertSelective(order);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
        return order;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generatorOrder(String faAddress, String reAddress, String reName, String rePhone, String orderNotes, String userNo){
        List<Order> orders = orderMapper.selectByUserNo(UserFilter.currentUser.getUserNo());
        Order tempOrder=null;
        for (Order order:orders){
            if (order.getOrderState().equals(Constant.OrderType.CURRENT)){
                tempOrder=order;
                break;
            }
        }
        if (tempOrder==null){
            throw new FurnitureException(FurnitureExceptionEnum.ORDER_NEED_PRO);
        }
        tempOrder.setFaAddress(faAddress);
        tempOrder.setReAddress(reAddress);
        tempOrder.setReName(reName);
        tempOrder.setRePhone(Long.valueOf(rePhone));
        List<OrderItem> orderItems = orderItemMapper.selectByOrderNo(tempOrder.getOrderNo());
        BigDecimal tempSum=BigDecimal.ZERO;
        for (OrderItem orderItem:orderItems){
            tempSum=orderItem.getTempPrice().add(tempSum);
        }
        tempOrder.setSumPrice(tempSum);
        tempOrder.setOrderState(Constant.OrderType.NO_DELIVERED);
        if (orderNotes!=null){
            tempOrder.setOrderNotes(orderNotes);
        }
        tempOrder.setUserNo(userNo);
        int count = orderMapper.updateByPrimaryKeySelective(tempOrder);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.GENE_ORDER_ERR);
        }
    }

    @Override
    public List<ResponseItem> selectByOrderNo(String orderNo){
        List<OrderItem> orderItems = orderItemMapper.selectByOrderNo(orderNo);
        List<ResponseItem> result=new ArrayList<>();
        for (OrderItem orderItem:orderItems){
            ResponseItem responseItem=new ResponseItem();
            ProShop proShop = proShopMapper.selectByPro(orderItem.getProNo());
            responseItem.setProNo(orderItem.getProNo());
            responseItem.setProName(proShop.getProName());
            responseItem.setProDesc(proShop.getProDesc());
            responseItem.setProUrl(proShop.getProUrl());
            responseItem.setProCount(String.valueOf(orderItem.getProCount()));
            responseItem.setUnitPrice(proShop.getUnitPrice());
            responseItem.setTempPrice(orderItem.getTempPrice());
            responseItem.setUserNo(orderItem.getUserNo());
            result.add(responseItem);
        }
        return result;
    }

    @Override
    public List<OrderItem> selectItemByUser(String userNo){

        List<OrderItem> orderItems = orderItemMapper.queryByUserNo(userNo);

//        List<OrderItem> orderItems = orderItemMapper.selectByUserNo(UserFilter.currentUser.getUserNo());
//        List<ResponseItem> result=new ArrayList<>();
//        for (OrderItem orderItem:orderItems){
//            ResponseItem responseItem=new ResponseItem();
//            ProShop proShop = proShopMapper.selectByPro(orderItem.getProNo());
//            responseItem.setItemId(orderItem.getItemId());
//            responseItem.setProNo(orderItem.getProNo());
//            responseItem.setProName(proShop.getProName());
//            responseItem.setProDesc(proShop.getProDesc());
//            responseItem.setProUrl(proShop.getProUrl());
//            responseItem.setProCount(String.valueOf(orderItem.getProCount()));
//            responseItem.setUnitPrice(proShop.getUnitPrice());
//            responseItem.setTempPrice(orderItem.getTempPrice());
//            responseItem.setUserNo(orderItem.getUserNo());
//            result.add(responseItem);
//        }
        return orderItems;
    }

    @Override
    public void deleteItem(Long itemId){
        int count = orderItemMapper.deleteByPrimaryKey(itemId);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    public void addItem(OrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    @Override
    public List<OrderItem> selectRecord(OrderItem orderItem) {
        return orderItemMapper.selectRecord(orderItem);
    }

    @Override
    public ProShop selectByPro(String proNo) {
        return proShopMapper.selectByPro(proNo);
    }

    @Override
    public List<OrderItem> queryCartByUserAndName(String userNo, String proName) {
        return orderItemMapper.queryCartByUserAndName(userNo, proName);
    }

    @Override
    public void del(String userNo, String proNo) {
        orderItemMapper.del(userNo, proNo);
    }

    @Override
    public void cancel(String uuid) {
        orderItemMapper.cancel(uuid);
    }

    @Override
    public void updateOrder(String uuid, String orderState) {
        orderItemMapper.updateOrder(uuid, orderState);
    }

    @Override
    public void delete(String uuid) {
        orderItemMapper.delete(uuid);
    }

    @Override
    public int queryProCount(String proNo) {
        return proShopMapper.queryProCount(proNo);
    }

    @Override
    public void addOrder(OrderItem oi) {
        orderItemMapper.addOrder(oi);
    }

    @Override
    public int updateInventory(ProShop proShop) {
        return proShopMapper.updateRecord(proShop);
    }

    @Override
    public List<MyOrder> orderListAll(String userNo) {
        List<MyOrder> orders = orderMapper.orderListAll(userNo);
        return orders;
    }

    @Override
    public List<MyOrder> orderListByProName(String userNo, String proName) {
        return orderMapper.orderListByProName(userNo, proName);
    }

    @Override
    public void sureOrder(String uuid) {
        orderMapper.sureOrder(uuid);
    }


}
