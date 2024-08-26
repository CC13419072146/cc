package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.SysComment;
import com.furniture.shopping.model.pojo.SysMessage;
import com.furniture.shopping.model.vo.CurMsg;

import java.util.List;

/**
 * 消息业务逻辑类
 */
public interface MessageService {
    List<CurMsg> allMsg();

    void priBack(String userNo, String message);

    List<SysMessage> pubMsg();

    void pubBack(String message);

    void addTalk(SysMessage msg);

    List<SysMessage> getMsgList(int pageSize, int page);

    List<SysMessage> searchMsg(int page, int pageSize, String content,
                               String searchTimeStart, String searchTimeEnd);

    List<SysComment> getCommentList(Long msgId);

    void pushComment(SysComment sysComment);

    void delMsg(int msgId);
}
