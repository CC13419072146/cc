package com.furniture.shopping.model.pojo;

public class DesiPro {
    private Long desiId;

    private String desiUrl;

    private String desiTitle;

    private String desiDesc;

    private String userNo;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDesiId() {
        return desiId;
    }

    public void setDesiId(Long desiId) {
        this.desiId = desiId;
    }

    public String getDesiUrl() {
        return desiUrl;
    }

    public void setDesiUrl(String desiUrl) {
        this.desiUrl = desiUrl == null ? null : desiUrl.trim();
    }

    public String getDesiTitle() {
        return desiTitle;
    }

    public void setDesiTitle(String desiTitle) {
        this.desiTitle = desiTitle == null ? null : desiTitle.trim();
    }

    public String getDesiDesc() {
        return desiDesc;
    }

    public void setDesiDesc(String desiDesc) {
        this.desiDesc = desiDesc == null ? null : desiDesc.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
}