package com.furniture.shopping.model.vo;

import java.util.Date;

public class CurMsg {
    private String userNo;

    private String userName;

    private Date msgDate;

    private String otherNo;

    private String otherName;

    private String msgDetail;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public String getOtherNo() {
        return otherNo;
    }

    public void setOtherNo(String otherNo) {
        this.otherNo = otherNo;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }
}
