package com.furniture.shopping.model.pojo;

import java.math.BigDecimal;

public class Order {
    private Long orderId;

    private String orderNo;

    private String faAddress;

    private String reAddress;

    private String reName;

    private Long rePhone;

    private BigDecimal sumPrice;

    private String orderState;

    private String orderNotes;

    private String userNo;

    private int shopCount;

    private String shopId;

    public int getShopCount() {
        return shopCount;
    }

    public void setShopCount(int shopCount) {
        this.shopCount = shopCount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getFaAddress() {
        return faAddress;
    }

    public void setFaAddress(String faAddress) {
        this.faAddress = faAddress == null ? null : faAddress.trim();
    }

    public String getReAddress() {
        return reAddress;
    }

    public void setReAddress(String reAddress) {
        this.reAddress = reAddress == null ? null : reAddress.trim();
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName == null ? null : reName.trim();
    }

    public Long getRePhone() {
        return rePhone;
    }

    public void setRePhone(Long rePhone) {
        this.rePhone = rePhone;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes == null ? null : orderNotes.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
}