package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.SysChat;
import com.furniture.shopping.model.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMapper {
    void insertChat(SysChat chat);

    int getUnReadCountByProNo(String sender, String receiver, String proNo);

    SysChat getChatList(String userNo, String other);

    int getUnReadCount(String sender, String receiver);

    List<SysChat> getChatContentList(String sender, String receiver);

    List<String> getChatByUserNoIsSender(String userNo);

    List<String> getChatByUserNoIsReceiver(String userNo);

    User getOtherUser(String userNo);

    void setRead(String sender, String receiver);
}
