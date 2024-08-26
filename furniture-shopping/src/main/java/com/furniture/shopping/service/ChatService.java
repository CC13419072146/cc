package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.SysChat;

import java.util.List;

public interface ChatService {
    void insertChat(SysChat chat);

    int getUnReadCountByProNo(String sender, String receiver, String proNo);

    List<SysChat> getChatList(String userNo);

    List<SysChat> getChatContentList(String sender, String receiver);

    void setRead(String sender, String receiver);
}
