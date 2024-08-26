package com.furniture.shopping.service.impl;

import com.furniture.shopping.model.dao.ChatMapper;
import com.furniture.shopping.model.pojo.SysChat;
import com.furniture.shopping.model.pojo.User;
import com.furniture.shopping.service.ChatService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private ChatMapper chatMapper;
    @Override
    public void insertChat(SysChat chat) {
        chatMapper.insertChat(chat);
    }

    @Override
    public int getUnReadCountByProNo(String sender, String receiver, String proNo) {
        return chatMapper.getUnReadCountByProNo(sender, receiver, proNo);
    }

    @Override
    public List<SysChat> getChatList(String userNo) {

        //获取以 userNo 为发送者的聊天的接受者
        List<String> receivers = chatMapper.getChatByUserNoIsSender(userNo);
        receivers = receivers.stream().distinct().collect(Collectors.toList());
        //获取以 userNo 为接受者的聊天的发送者
        List<String> senders = chatMapper.getChatByUserNoIsReceiver(userNo);
        senders = senders.stream().distinct().collect(Collectors.toList());
        List<String> temp = new ArrayList<>();
        temp.addAll(receivers);
        for (int j = 0 ; j < senders.size() ; j++) {
            if (!receivers.contains(senders.get(j))) {
                temp.add(senders.get(j));
            }
        }
        List<SysChat> chatList = new ArrayList<>();
        for (int i = 0 ; i < temp.size() ; i++) {
            SysChat sysChat = chatMapper.getChatList(userNo, temp.get(i));
            User otherUser = chatMapper.getOtherUser(temp.get(i));
            int unReadCount = chatMapper.getUnReadCount(temp.get(i), userNo);
            sysChat.setImgSrc(otherUser.getAvatar());
            sysChat.setSenderName(otherUser.getUserName());
            sysChat.setSender(temp.get(i));
            sysChat.setUnReadCount(unReadCount);
            chatList.add(sysChat);
        }
        chatList = chatList.stream().sorted((e1, e2) -> {
            return 0 - e1.getChatDate().compareTo(e2.getChatDate());
        }).collect(Collectors.toList());
        return chatList;
    }

    @Override
    public List<SysChat> getChatContentList(String sender, String receiver) {
        return chatMapper.getChatContentList(sender, receiver);
    }

    @Override
    public void setRead(String sender, String receiver) {
        chatMapper.setRead(sender, receiver);
    }
}
