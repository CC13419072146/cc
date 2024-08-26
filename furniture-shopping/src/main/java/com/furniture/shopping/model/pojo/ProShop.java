package com.furniture.shopping.model.pojo;

import java.math.BigDecimal;

public class ProShop {
    private Long proId;

    private String proNo;

    private String proName;

    private BigDecimal unitPrice;

    private String proDesc;

    private String proUrl;

    private String userNo;

    private String userName;

    private Long inventory;

    private int salesVolume;

    private int unReadCount;

    private String proCate;

    public int getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNo() {
        return proNo;
    }

    public void setProNo(String proNo) {
        this.proNo = proNo == null ? null : proNo.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc == null ? null : proDesc.trim();
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl == null ? null : proUrl.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getProCate() {
        return proCate;
    }

    public void setProCate(String proCate) {
        this.proCate = proCate;
    }
}