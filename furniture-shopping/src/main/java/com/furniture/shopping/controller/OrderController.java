package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.filter.UserFilter;
import com.furniture.shopping.model.pojo.MyOrder;
import com.furniture.shopping.model.pojo.Order;
import com.furniture.shopping.model.pojo.OrderItem;
import com.furniture.shopping.model.pojo.ProShop;
import com.furniture.shopping.model.vo.ResponseItem;
import com.furniture.shopping.service.OrderService;
import com.furniture.shopping.service.ProShopService;
import com.furniture.shopping.utils.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 订单控制器
 */
@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/all")
    @ResponseBody
    public ApiRestResponse<?> allOrder(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<Order> orders = orderService.selectByUserNo(UserFilter.currentUser.getUserNo());
        map.put("list",orders);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/cancel")
    @ResponseBody
    public ApiRestResponse<?> cancel(@RequestParam("orderId") Long orderId){
        orderService.cancel(orderId);
        return ApiRestResponse.success();
    }

    @PostMapping("/delivered")
    @ResponseBody
    public ApiRestResponse<?> delivered(@RequestParam("orderId") Long orderId){
        orderService.delivered(orderId);
        return ApiRestResponse.success();
    }

    @PostMapping("/finished")
    @ResponseBody
    public ApiRestResponse<?> finished(@RequestParam("orderId") Long orderId){
        orderService.finished(orderId);
        return ApiRestResponse.success();
    }

    @PostMapping("/generator/order")
    @ResponseBody
    public ApiRestResponse<?> generatorOrder(@RequestParam("faAddress") String faAddress,@RequestParam("reAddress") String reAddress,@RequestParam("reName") String reName,@RequestParam("rePhone") String rePhone,@RequestParam(name = "orderNotes",required = false) String orderNotes,@RequestParam("userNo") String userNo){
        orderService.generatorOrder(faAddress, reAddress, reName, rePhone, orderNotes, userNo);
        return ApiRestResponse.success();
    }

    @PostMapping("/item/byno")
    @ResponseBody
    public ApiRestResponse<?> selectOrderItem(@RequestParam("orderNo") String orderNo){
        List<ResponseItem> orderItems = orderService.selectByOrderNo(orderNo);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("list",orderItems);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/item/by/user")
    @ResponseBody
    public ApiRestResponse<?> selectByUserNo(String userNo){
        List<OrderItem> orderItems = orderService.selectItemByUser(userNo);
        return ApiRestResponse.success(orderItems);
    }

    @PostMapping("/delete/item")
    @ResponseBody
    public ApiRestResponse<?> deleteItem(@RequestParam("itemId") Long itemId){
        orderService.deleteItem(itemId);
        return ApiRestResponse.success();
    }

    @PostMapping("/item/queryCart")
    @ResponseBody
    public ApiRestResponse<?> queryCart(String userNo, String proName) {
        List<OrderItem> orderItems = orderService.queryCartByUserAndName(userNo, proName);
        return ApiRestResponse.success(orderItems);
    }

    @PostMapping("/item/del")
    @ResponseBody
    public ApiRestResponse<?> del(String userNo, String proNo) {
        orderService.del(userNo, proNo);
        return ApiRestResponse.success("删除成功");
    }

    @PostMapping("/item/cancel")
    @ResponseBody
    public ApiRestResponse<?> cancel(String uuid) {
        orderService.cancel(uuid);
        return ApiRestResponse.success("操作成功");
    }

    @PostMapping("/item/updateOrder")
    @ResponseBody
    public ApiRestResponse<?> updateOrder(String uuid, String orderState) {
        orderService.updateOrder(uuid, orderState);
        return ApiRestResponse.success("操作成功");
    }

    @PostMapping("/delete")
    @ResponseBody
    public ApiRestResponse<?> delete(String uuid) {
        orderService.delete(uuid);
        return ApiRestResponse.success("删除成功");
    }

    @PostMapping("/item/add")
    @ResponseBody
    public ApiRestResponse<?> addItem(OrderItem oi) {

        ProShop proShop = orderService.selectByPro(oi.getProNo());
        if (proShop == null) {
            return ApiRestResponse.error("当前商品已下架");
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setUserNo(oi.getUserNo());
        orderItem.setProNo(oi.getProNo());
        List<OrderItem> orderItems = orderService.selectRecord(orderItem);
        if (orderItems != null && orderItems.size() > 0) {
            return ApiRestResponse.success("加入购物车成功");
        }
        orderService.addItem(oi);

        return ApiRestResponse.success("加入购物车成功");
    }

    //购买商品
    @PostMapping("/order/purchase")
    @ResponseBody
    @Transactional
    public ApiRestResponse<?> purchase(OrderItem oi) {
        /*
        *   购买商品时的步骤:
        *       1、查询商品是否存在，存在则可购买，否则不能购买
        *       2、查询商品表中库存是否足够，足够可购买，否则不能购买
        *       3、插入数据到订单表中
        *       4、删除购物车表数据
        *       5、库存减去购买的数量
        * */
        ProShop proShop = orderService.selectByPro(oi.getProNo());
        if (proShop == null) {
            return ApiRestResponse.error("当前商品已下架");
        }
        int count = orderService.queryProCount(oi.getProNo());
        if (count < oi.getProCount()) {
            return ApiRestResponse.error("商品库存不足");
        }
        oi.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        orderService.addOrder(oi);
        orderService.del(oi.getUserNo(), oi.getProNo());

        ProShop update = new ProShop();
        update.setProNo(oi.getProNo());
        update.setInventory(proShop.getInventory() - oi.getProCount());
        orderService.updateInventory(update);
        return ApiRestResponse.success("购买成功");
    }

    //订单列表
    @PostMapping("/order/orderList")
    @ResponseBody
    public ApiRestResponse<?> orderList(String userNo, String proName) {
        List<MyOrder> orders = new ArrayList<>();
        if (StringUtils.isEmpty(proName)) {
            orders = orderService.orderListAll(userNo);
        } else {
            orders = orderService.orderListByProName(userNo, proName);
        }
        return ApiRestResponse.success(orders);
    }

    //购买商品
    @PostMapping("/order/sureOrder")
    @ResponseBody
    public ApiRestResponse<?> sureOrder(String uuid) {
        orderService.sureOrder(uuid);
        return ApiRestResponse.success("收货成功");
    }

    @GetMapping("/generate/qrcode")
    public void generateV2(String content, HttpServletResponse servletResponse){
        try {
            QRCodeUtil.createCodeToOutputStream(content,servletResponse.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
