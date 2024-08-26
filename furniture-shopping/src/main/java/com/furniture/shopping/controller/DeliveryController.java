package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.pojo.SysDelivery;
import com.furniture.shopping.service.DeliveryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 配送单控制器
 */
@Controller
@RequestMapping("/api/del")
public class DeliveryController {
    @Resource
    private DeliveryService deliveryService;

    @PostMapping("/all")
    @ResponseBody
    public ApiRestResponse<?> allDelivery(){
        List<SysDelivery> sysDeliveries = deliveryService.allDelivery(UserFilter.currentUser.getUserNo());
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",sysDeliveries);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/generator")
    @ResponseBody
    public ApiRestResponse<?> generator(@RequestParam("delName") String delName,@RequestParam("delPhone") String delPhone,@RequestParam("delAddress") String delAddress,@RequestParam("orderNo") String orderNo){
        SysDelivery generator = deliveryService.generator(delName, delPhone, delAddress, orderNo);
        return ApiRestResponse.success(generator);
    }

    @PostMapping("/del/err")
    @ResponseBody
    public ApiRestResponse<?> delError(@RequestParam("delId") Long delId){
        deliveryService.delError(delId);
        return ApiRestResponse.success();
    }

    @PostMapping("/del/succ")
    @ResponseBody
    public ApiRestResponse<?> delSucc(@RequestParam("delId") Long delId){
        deliveryService.delSucc(delId);
        return ApiRestResponse.success();
    }
}
