package com.furniture.shopping.model.pojo;

public class SysDelivery {
    private Long delId;

    private String delName;

    private Long delPhone;

    private String delAddress;

    private String orderNo;

    private String delState;

    private String userNo;

    public Long getDelId() {
        return delId;
    }

    public void setDelId(Long delId) {
        this.delId = delId;
    }

    public String getDelName() {
        return delName;
    }

    public void setDelName(String delName) {
        this.delName = delName == null ? null : delName.trim();
    }

    public Long getDelPhone() {
        return delPhone;
    }

    public void setDelPhone(Long delPhone) {
        this.delPhone = delPhone;
    }

    public String getDelAddress() {
        return delAddress;
    }

    public void setDelAddress(String delAddress) {
        this.delAddress = delAddress == null ? null : delAddress.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState == null ? null : delState.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
}