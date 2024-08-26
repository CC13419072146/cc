package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.SysComment;
import com.furniture.shopping.model.pojo.SysMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMessageMapper {
    int deleteByPrimaryKey(Long msgId);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    SysMessage selectByPrimaryKey(Long msgId);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);

    List<SysMessage> allMsg(String userNo);

    List<SysMessage> allAll();

    void addTalk(SysMessage msg);

    List<SysMessage> getMsgList(int pageSize, int page);

    List<SysMessage> searchMsg(int page, int pageSize, String content, String searchTimeStart, String searchTimeEnd);

    List<SysComment> getCommentList(Long msgId);

    void pushComment(SysComment sysComment);

    void delMsg(int msgId);
}