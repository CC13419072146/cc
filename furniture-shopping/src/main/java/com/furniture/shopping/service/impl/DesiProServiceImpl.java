package com.furniture.shopping.service.impl;

import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.DesiProMapper;
import com.furniture.shopping.model.pojo.DesiPro;
import com.furniture.shopping.service.DesiProService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设计方案逻辑实现类
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DesiProServiceImpl implements DesiProService {
    @Resource
    private DesiProMapper desiProMapper;

    @Override
    public List<DesiPro> selectByNo(){
        return desiProMapper.selectByNo(UserFilter.currentUser.getUserNo());
    }

    @Override
    public List<DesiPro> allPlan() {
        return desiProMapper.allPlan();
    }

    @Override
    public void insertDesi(DesiPro desiPro){
        int count = desiProMapper.insertSelective(desiPro);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void deleteDesi(Long desiId){
        int count = desiProMapper.deleteByPrimaryKey(desiId);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    public void updateDesi(DesiPro desiPro){
        int count = desiProMapper.updateByPrimaryKeySelective(desiPro);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }
}
