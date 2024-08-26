package com.furniture.shopping.model.vo;

import java.math.BigDecimal;

public class ResponseItem {
    private String proNo;

    private String proName;

    private String proDesc;

    private String proUrl;

    private String proCount;

    private BigDecimal unitPrice;

    private BigDecimal tempPrice;

    private String userNo;

    private Long itemId;

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
        this.proNo = proNo;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    public String getProCount() {
        return proCount;
    }

    public void setProCount(String proCount) {
        this.proCount = proCount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTempPrice() {
        return tempPrice;
    }

    public void setTempPrice(BigDecimal tempPrice) {
        this.tempPrice = tempPrice;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}