package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.SysDelivery;

import java.util.List;

/**
 * 配送业务逻辑类
 */
public interface DeliveryService {
    List<SysDelivery> allDelivery(String userNo);

    SysDelivery generator(String delName, String delPhone, String delAddress, String orderNo);

    void delError(Long delId);

    void delSucc(Long delId);
}
