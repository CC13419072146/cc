package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.model.pojo.SysComment;
import com.furniture.shopping.model.pojo.SysMessage;
import com.furniture.shopping.model.vo.CurMsg;
import com.furniture.shopping.service.MessageService;
import com.furniture.shopping.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息控制器
 */
@Controller
@RequestMapping("/api/msg")
public class MessageController {
    @Resource
    private MessageService messageService;

    @PostMapping("/pri")
    @ResponseBody
    public ApiRestResponse<?> priMsg(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<CurMsg> sysMessages = messageService.allMsg();
        if (sysMessages.size()>5){
            sysMessages=sysMessages.subList(sysMessages.size()-5,sysMessages.size());
        }
        map.put("list",sysMessages);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/pri/back")
    @ResponseBody
    public ApiRestResponse<?> priBack(@RequestParam("userNo") String userNo,@RequestParam("msgDetail") String msgDetail){
        messageService.priBack(userNo, msgDetail);
        return ApiRestResponse.success();
    }

    @PostMapping("/pub/msg")
    @ResponseBody
    public ApiRestResponse<?> pubMsg(){
        List<SysMessage> sysMessages = messageService.pubMsg();
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",sysMessages);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/pub/back")
    @ResponseBody
    public ApiRestResponse<?> pubBack(@RequestParam("msgDetail") String msgDetail){
        messageService.pubBack(msgDetail);
        return ApiRestResponse.success();
    }

    private static final String SPLIT_PIC_SYMBOL = "#=#";

    @PostMapping("/pushMsg")
    @ResponseBody
    public ApiRestResponse<?> pushMsg(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request){
        String msgDetail = request.getParameter("msgDetail");
        String userNo = request.getParameter("userNo");
        String userName = request.getParameter("userName");
        if (userName == null || userName.trim().equals("")) {
            return ApiRestResponse.error("请重新登陆");
        }
        StringBuilder talkPictures = new StringBuilder();
        if (files != null && files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
                String url = FileUtils.uploadFile(files.get(i), request);
                talkPictures.append(url + SPLIT_PIC_SYMBOL);
            }
        }
        String talkPicture = talkPictures.toString();
        talkPicture = talkPicture.substring(0, talkPicture.lastIndexOf(SPLIT_PIC_SYMBOL));
        SysMessage msg = new SysMessage();
        msg.setUserNo(userNo);
        msg.setMsgDetail(msgDetail);
        msg.setTalkPicture(talkPicture);
        msg.setUserName(userName);
        messageService.addTalk(msg);
        return ApiRestResponse.success();
    }

    @PostMapping("/getMsgList")
    @ResponseBody
    public ApiRestResponse<?> pushMsg(int page, int pageSize) {
        List<SysMessage> msgs = messageService.getMsgList(pageSize, page);
        msgs.forEach(msg -> {
            msg.setTalkPictures(Arrays.asList(msg.getTalkPicture().split(SPLIT_PIC_SYMBOL)));
            List<SysComment> commentList = messageService.getCommentList(msg.getMsgId());
            msg.setSysComments(commentList);
        });
        return ApiRestResponse.success(msgs);
    }

    @PostMapping("/searchMsg")
    @ResponseBody
    public ApiRestResponse<?> searchMsg(int page, int pageSize, String content,
                                      String searchTimeStart, String searchTimeEnd) {
        List<SysMessage> msgs = messageService.searchMsg(page, pageSize, content,
                searchTimeStart, searchTimeEnd);
        msgs.forEach(msg -> {
            msg.setTalkPictures(Arrays.asList(msg.getTalkPicture().split(SPLIT_PIC_SYMBOL)));
            List<SysComment> commentList = messageService.getCommentList(msg.getMsgId());
            msg.setSysComments(commentList);
        });
        return ApiRestResponse.success(msgs);
    }
    @PostMapping("/pushComment")
    @ResponseBody
    public ApiRestResponse<?> pushComment(SysComment sysComment) {
        messageService.pushComment(sysComment);
        return ApiRestResponse.success();
    }

    @PostMapping("/delMsg")
    @ResponseBody
    public ApiRestResponse<?> delMsg(int msgId) {
        messageService.delMsg(msgId);
        return ApiRestResponse.success();
    }
}
