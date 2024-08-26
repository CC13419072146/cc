package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.pojo.DesiPro;
import com.furniture.shopping.service.DesiProService;
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
 * 设计师控制器
 */
@Controller
@RequestMapping("/api/desi")
public class DesiProController {
    @Resource
    private DesiProService desiProService;

    @PostMapping("/all")
    @ResponseBody
    public ApiRestResponse<?> selectAll(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<DesiPro> desiPros = desiProService.selectByNo();
        map.put("list",desiPros);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/allPlan")
    @ResponseBody
    public ApiRestResponse<?> allPlan(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<DesiPro> desiPros = desiProService.allPlan();
        map.put("list",desiPros);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/insert")
    @ResponseBody
    public ApiRestResponse<?> insertDesi(@RequestParam("desiUrl") String desiUrl,@RequestParam("desiTitle") String desiTitle,@RequestParam("desiDesc") String desiDesc){
        DesiPro desiPro=new DesiPro();
        desiPro.setDesiUrl(desiUrl);
        desiPro.setDesiTitle(desiTitle);
        desiPro.setUserNo(UserFilter.currentUser.getUserNo());
        desiPro.setDesiDesc(desiDesc);
        desiProService.insertDesi(desiPro);
        return ApiRestResponse.success();
    }

    @PostMapping("/delete")
    @ResponseBody
    public ApiRestResponse<?> deleteDesi(@RequestParam("desiId") Long desiId){
        desiProService.deleteDesi(desiId);
        return ApiRestResponse.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse<?> updateDesi(DesiPro desiPro){
        desiProService.updateDesi(desiPro);
        return ApiRestResponse.success();
    }
}
