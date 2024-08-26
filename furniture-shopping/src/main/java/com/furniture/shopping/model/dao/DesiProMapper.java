package com.furniture.shopping.model.dao;

import com.furniture.shopping.model.pojo.DesiPro;

import java.util.List;

public interface DesiProMapper {
    int deleteByPrimaryKey(Long desiId);

    int insert(DesiPro record);

    int insertSelective(DesiPro record);

    DesiPro selectByPrimaryKey(Long desiId);

    int updateByPrimaryKeySelective(DesiPro record);

    int updateByPrimaryKey(DesiPro record);

    List<DesiPro> selectByNo(String userNo);

    List<DesiPro> allPlan();
}