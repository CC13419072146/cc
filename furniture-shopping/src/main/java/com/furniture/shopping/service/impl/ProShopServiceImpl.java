package com.furniture.shopping.service.impl;

import com.furniture.shopping.common.Constant;
import com.furniture.shopping.exception.FurnitureException;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.dao.OrderItemMapper;
import com.furniture.shopping.model.dao.ProShopMapper;
import com.furniture.shopping.model.pojo.Order;
import com.furniture.shopping.model.pojo.OrderItem;
import com.furniture.shopping.model.pojo.ProShop;
import com.furniture.shopping.service.OrderService;
import com.furniture.shopping.service.ProShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品业务逻辑实现类
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ProShopServiceImpl implements ProShopService {
    @Resource
    private ProShopMapper proShopMapper;
    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public List<ProShop> selectByNo(String userNo){
        List<ProShop> proShops = proShopMapper.selectByNo(userNo);
        return proShops;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProShop insertPro(ProShop proShop){
        int count = proShopMapper.insertSelective(proShop);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
        return proShop;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePro(Long proId){
        int count = proShopMapper.deleteByPrimaryKey(proId);
        if(count==0){
            throw new FurnitureException(FurnitureExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProNo(String proNo){
        int count = proShopMapper.deleteProNo(proNo);
        if(count==0){
            throw new FurnitureException(FurnitureExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePro(ProShop proShop){
        int count = proShopMapper.updateByPrimaryKeySelective(proShop);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void tempPro(String proNo,String proCount){
        List<Order> orders = orderService.selectByUserNo(UserFilter.currentUser.getUserNo());
        String tempOrderNo=null;
        for (Order order:orders){
            if (order.getUserNo().equals(UserFilter.currentUser.getUserNo())&&order.getOrderState().equals(Constant.OrderType.CURRENT)) {
                tempOrderNo=order.getOrderNo();
            }
        }
        if (tempOrderNo==null){
            Order order = orderService.generatorTempOrder("temp", "temp", "temp", "123", null);
            tempOrderNo=order.getOrderNo();
        }
        OrderItem orderItem=new OrderItem();
        orderItem.setProNo(proNo);
        ProShop tempPro = proShopMapper.selectByPro(proNo);
        if (Integer.parseInt(proCount)> tempPro.getInventory()){
            throw new FurnitureException(FurnitureExceptionEnum.PRO_NO_ENOUGH);
        }
        orderItem.setProCount(Long.valueOf(proCount));
        orderItem.setTempPrice(BigDecimal.valueOf(Double.parseDouble(proCount)).multiply(tempPro.getUnitPrice()));
        orderItem.setOrderNo(tempOrderNo);
        orderItem.setUserNo(UserFilter.currentUser.getUserNo());
        int count = orderItemMapper.insertSelective(orderItem);
        if (count==0){
            throw new FurnitureException(FurnitureExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public List<ProShop> smartPro(){
        List<OrderItem> orderItems = orderItemMapper.selectByUserNo(UserFilter.currentUser.getUserNo());
        List<ProShop> proShops = proShopMapper.selectAll();
        List<ProShop> result=new ArrayList<>();
        for (ProShop proShop:proShops){
            for (OrderItem orderItem:orderItems){
                if (orderItem.getProNo().equals(proShop.getProNo())&&!result.contains(proShop)){
                    result.add(proShop);
                }
            }
        }
        if (result.size()==0){
            return proShops;
        }
        return result;
    }

    @Override
    public List<ProShop> getAllGoods() {
        return proShopMapper.selectAll();
    }

    @Override
    public List<ProShop> findPro(String proName, String proCate){
        List<ProShop> proShopList = new ArrayList<>();
        if (StringUtils.hasText(proCate) || StringUtils.hasText(proName)) {
            proShopList = proShopMapper.findPro(proName, proCate);
        } else {
            proShopList = proShopMapper.selectAll();
        }
//        if (proName == null || proName.equals("")) {
//            proShopList = proShopMapper.selectAll();
//        } else {
//            proShopList = proShopMapper.findPro(proName);
//        }
        return proShopList;
    }

    @Override
    public List<ProShop> getSuggestGoods() {
        return proShopMapper.getSuggestGoods();
    }
}
