package com.furniture.shopping.service.impl;

import com.furniture.shopping.common.Constant;
import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.SysMessageMapper;
import com.furniture.shopping.model.dao.UserMapper;
import com.furniture.shopping.model.pojo.SysComment;
import com.furniture.shopping.model.pojo.SysMessage;
import com.furniture.shopping.model.pojo.User;
import com.furniture.shopping.model.vo.CurMsg;
import com.furniture.shopping.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消息逻辑实现类
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class MessageServiceImpl implements MessageService {
    @Resource
    private SysMessageMapper messageMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<CurMsg> allMsg(){
        List<SysMessage> sysMessages = messageMapper.allMsg(UserFilter.currentUser.getUserNo());
        List<SysMessage> result=new ArrayList<>();
        for (SysMessage sysMessage:sysMessages){
            if (sysMessage.getMsgType().equals(Constant.msgType.PUB_TYPE)){
                continue;
            }
            result.add(sysMessage);
        }
        List<CurMsg> curResult=new ArrayList<>();
        for (SysMessage sysMessage:result){
            CurMsg curMsg=new CurMsg();
            BeanUtils.copyProperties(sysMessage,curMsg);
            User user = userMapper.selectByNo(curMsg.getOtherNo());
            curMsg.setOtherName(user.getUserName());
            curResult.add(curMsg);
        }
        return curResult;
    }

    @Override
    public void priBack(String userNo, String message){
        SysMessage sysMessage=new SysMessage();
        sysMessage.setMsgType(Constant.msgType.PRI_TYPE);
        sysMessage.setUserNo(UserFilter.currentUser.getUserNo());
        sysMessage.setUserName(UserFilter.currentUser.getUserName());
        sysMessage.setMsgDate(new Date().toString());
        sysMessage.setOtherNo(userNo);
        sysMessage.setMsgDetail(message);
        int count = messageMapper.insertSelective(sysMessage);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public List<SysMessage> pubMsg(){
        List<SysMessage> sysMessages = messageMapper.allAll();
        List<SysMessage> result=new ArrayList<>();
        for (SysMessage sysMessage:sysMessages){
            if (sysMessage.getMsgType().equals(Constant.msgType.PUB_TYPE)){
                result.add(sysMessage);
            }
        }
        return result;
    }

    @Override
    public void pubBack(String message){
        SysMessage sysMessage=new SysMessage();
        sysMessage.setMsgType(Constant.msgType.PUB_TYPE);
        sysMessage.setUserNo(UserFilter.currentUser.getUserNo());
        sysMessage.setUserName(UserFilter.currentUser.getUserName());
        sysMessage.setMsgDate(new Date().toString());
        sysMessage.setMsgDetail(message);
        int count = messageMapper.insertSelective(sysMessage);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void addTalk(SysMessage msg) {
        messageMapper.addTalk(msg);
    }

    @Override
    public List<SysMessage> getMsgList(int pageSize, int page) {
        return messageMapper.getMsgList(pageSize, page);
    }

    @Override
    public List<SysMessage> searchMsg(int page, int pageSize, String content, String searchTimeStart, String searchTimeEnd) {
        return messageMapper.searchMsg(page, pageSize, content, searchTimeStart, searchTimeEnd);
    }

    @Override
    public List<SysComment> getCommentList(Long msgId) {
        return messageMapper.getCommentList(msgId);
    }

    @Override
    public void pushComment(SysComment sysComment) {
        messageMapper.pushComment(sysComment);
    }

    @Override
    public void delMsg(int msgId) {
        messageMapper.delMsg(msgId);
    }
}
