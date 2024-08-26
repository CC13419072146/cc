package com.furniture.shopping.model.pojo;

import java.util.List;

public class SysMessage {
    private Long msgId;

    private String msgType;

    private String userNo;

    private String userName;

    private String msgDate;

    private String otherNo;

    private String msgDetail;

    private String talkPicture;

    private List<String> talkPictures;

    private String userAvatar;

    private List<SysComment> sysComments;

    public List<SysComment> getSysComments() {
        return sysComments;
    }

    public void setSysComments(List<SysComment> sysComments) {
        this.sysComments = sysComments;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public List<String> getTalkPictures() {
        return talkPictures;
    }

    public void setTalkPictures(List<String> talkPictures) {
        this.talkPictures = talkPictures;
    }

    public String getTalkPicture() {
        return talkPicture;
    }

    public void setTalkPicture(String talkPicture) {
        this.talkPicture = talkPicture;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    public String getOtherNo() {
        return otherNo;
    }

    public void setOtherNo(String otherNo) {
        this.otherNo = otherNo == null ? null : otherNo.trim();
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail == null ? null : msgDetail.trim();
    }
}