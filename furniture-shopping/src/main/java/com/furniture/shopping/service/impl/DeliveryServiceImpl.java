package com.furniture.shopping.service.impl;

import com.furniture.shopping.common.Constant;
import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.SysDeliveryMapper;
import com.furniture.shopping.model.pojo.SysDelivery;
import com.furniture.shopping.service.DeliveryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    private SysDeliveryMapper deliveryMapper;

    @Override
    public List<SysDelivery> allDelivery(String userNo){
        return deliveryMapper.selectByUserNo(userNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDelivery generator(String delName, String delPhone, String delAddress, String orderNo){
        SysDelivery sysDelivery=new SysDelivery();
        sysDelivery.setDelName(delName);
        sysDelivery.setDelPhone(Long.valueOf(delPhone));
        sysDelivery.setDelAddress(delAddress);
        sysDelivery.setOrderNo(orderNo);
        sysDelivery.setUserNo(UserFilter.currentUser.getUserNo());
        sysDelivery.setDelState(Constant.delState.DELING);
        int count = deliveryMapper.insertSelective(sysDelivery);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
        return sysDelivery;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delError(Long delId){
        SysDelivery sysDelivery = deliveryMapper.selectByPrimaryKey(delId);
        if (!sysDelivery.getDelState().equals(Constant.delState.DELING)){
            throw new FurnitureException(FurnitureExceptionEnum.DEL_ERR_STATE);
        }
        sysDelivery.setDelState(Constant.delState.ERROR);
        int count = deliveryMapper.updateByPrimaryKeySelective(sysDelivery);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delSucc(Long delId){
        SysDelivery sysDelivery = deliveryMapper.selectByPrimaryKey(delId);
        if (!sysDelivery.getDelState().equals(Constant.delState.DELING)){
            throw new FurnitureException(FurnitureExceptionEnum.DEL_ERR_STATE);
        }
        sysDelivery.setDelState(Constant.delState.DELED);
        int count = deliveryMapper.updateByPrimaryKeySelective(sysDelivery);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }
}
