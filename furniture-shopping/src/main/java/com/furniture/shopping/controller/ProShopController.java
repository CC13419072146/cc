package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.pojo.ProShop;
import com.furniture.shopping.service.ChatService;
import com.furniture.shopping.service.ProShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 商品控制类
 */
@Controller
@RequestMapping("/api/pro")
public class ProShopController {
    @Resource
    private ProShopService proShopService;

    @Resource
    private ChatService chatService;

    @PostMapping("/self/all")
    @ResponseBody
    public ApiRestResponse<?> selfAll(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<ProShop> proShops = proShopService.selectByNo(UserFilter.currentUser.getUserNo());
        map.put("list",proShops);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/insert/pro")
    @ResponseBody
    public ApiRestResponse<?> insertPro(@RequestParam("proName") String proName,
                                        @RequestParam("unitPrice") String unitPrice,
                                        @RequestParam("proDesc") String proDesc,
                                        @RequestParam("proUrl") String proUrl,
                                        @RequestParam("inventory") String inventory,
                                        @RequestParam("proCate") String proCate){
        ProShop proShop=new ProShop();
        proShop.setProNo(UUID.randomUUID().toString());
        proShop.setProName(proName);
        proShop.setUnitPrice(BigDecimal.valueOf(Double.parseDouble(unitPrice)));
        proShop.setProDesc(proDesc);
        proShop.setProUrl(proUrl);
        proShop.setUserNo(UserFilter.currentUser.getUserNo());
        proShop.setInventory(Long.valueOf(inventory));
        proShop.setProCate(proCate);
        ProShop proShop1 = proShopService.insertPro(proShop);
        return ApiRestResponse.success(proShop1);
    }

    @PostMapping("/delete/pro")
    @ResponseBody
    public ApiRestResponse<?> deletePro(@RequestParam("proId") Long proId, String proNo){
        proShopService.deletePro(proId);
        proShopService.deleteProNo(proNo);
        return ApiRestResponse.success();
    }

    @PostMapping("/update/pro")
    @ResponseBody
    public ApiRestResponse<?> updatePro(ProShop proShop){
        proShopService.updatePro(proShop);
        return ApiRestResponse.success();
    }

    @PostMapping("/pro/byno")
    @ResponseBody
    public ApiRestResponse<?> selectByUserNo(@RequestParam("userNo") String userNo){
        List<ProShop> proShops = proShopService.selectByNo(userNo);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",proShops);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/temp/pro")
    @ResponseBody
    public ApiRestResponse<?> tempPro(@RequestParam("proNo") String proNo,@RequestParam("proCount") String proCount){
        proShopService.tempPro(proNo, proCount);
        return ApiRestResponse.success();
    }

    @PostMapping("/pro/suggest")
    @ResponseBody
    public ApiRestResponse<?> smartPro(){
        List<ProShop> proShops = proShopService.smartPro();
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",proShops);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/find/pro")
    @ResponseBody
    public ApiRestResponse<?> findPro(@RequestParam("proName") String proName, String proCate){
        List<ProShop> proShopList = proShopService.findPro(proName, proCate);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",proShopList);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/getAllGoods")
    @ResponseBody
    public ApiRestResponse<?> getAllGoods(String userNo){
        List<ProShop> suggestGoods = proShopService.getSuggestGoods();
//        for (int i = 0 ; i < suggestGoods.size() ; i++) {
//            int unReadCount = chatService.getUnReadCountByProNo(
//                    suggestGoods.get(i).getUserNo(), userNo,
//                    suggestGoods.get(i).getProNo());
//            suggestGoods.get(i).setUnReadCount(unReadCount);
//        }
        return ApiRestResponse.success(suggestGoods);
    }
}
