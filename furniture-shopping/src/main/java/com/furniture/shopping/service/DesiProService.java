package com.furniture.shopping.service;

import com.furniture.shopping.model.pojo.DesiPro;

import java.util.List;

/**
 * 设计师方案逻辑类
 */
public interface DesiProService {
    List<DesiPro> selectByNo();

    List<DesiPro> allPlan();

    void insertDesi(DesiPro desiPro);

    void deleteDesi(Long desiId);

    void updateDesi(DesiPro desiPro);
}
