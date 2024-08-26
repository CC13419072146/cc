package com.furniture.shopping.model.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Long itemId;

    private String proUrl;

    private String proName;

    private int inventory;

    private String userName;

    private String proDesc;

    private String proNo;

    private Long proCount;

    private BigDecimal unitPrice;

    private BigDecimal tempPrice;

    private String orderNo;

    private String userNo;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getProNo() {
        return proNo;
    }

    public void setProNo(String proNo) {
        this.proNo = proNo == null ? null : proNo.trim();
    }

    public Long getProCount() {
        return proCount;
    }

    public void setProCount(Long proCount) {
        this.proCount = proCount;
    }

    public BigDecimal getTempPrice() {
        return tempPrice;
    }

    public void setTempPrice(BigDecimal tempPrice) {
        this.tempPrice = tempPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
}