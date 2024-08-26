package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.ProShop;

import java.util.List;

/**
 * 商品业务逻辑类
 */
public interface ProShopService {
    List<ProShop> selectByNo(String userNo);

    ProShop insertPro(ProShop proShop);

    void deletePro(Long proId);

    void deleteProNo(String proNo);

    void updatePro(ProShop proShop);

    void tempPro(String proNo, String ProCount);

    List<ProShop> smartPro();

    List<ProShop> getAllGoods();

    List<ProShop> findPro(String proName, String proCate);

    List<ProShop> getSuggestGoods();
}
