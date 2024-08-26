package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.ProShop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProShopMapper {
    int deleteByPrimaryKey(Long proId);

    int deleteProNo(String proNo);

    int insert(ProShop record);

    int insertSelective(ProShop record);

    ProShop selectByPrimaryKey(Long proId);

    int updateByPrimaryKeySelective(ProShop record);

    int updateRecord(ProShop record);

    int updateByPrimaryKey(ProShop record);

    List<ProShop> selectByNo(String userNo);

    ProShop selectByPro(String proNo);

    List<ProShop> selectAll();

    List<ProShop> findPro(String proName, String proCate);

    List<ProShop> getSuggestGoods();

    int queryProCount(String proNo);
}