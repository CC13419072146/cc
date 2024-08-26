package com.furniture.shopping.common;

import org.springframework.stereotype.Component;


/**
 * 描述：     常量值
 */
@Component
public class Constant {
    public static final String FURNITURE_USER = "furniture_user";
    public static final String SALT = "./.256";
    public static final String MDType = "MD5";

    public interface RoleType{
        Integer SUPER_ROOT=0;
        Integer SHOP=1;
        Integer DESIGNER=2;
        Integer USER=3;
    }

    public interface OrderType{
        String CANCELED="用户已取消";
        String NO_DELIVERED="未发货";
        String DELIVERED="已发货";
        String FINISHED="交易完成";
        String CURRENT="虚拟暂存单";
    }

    public interface delState{
        String ERROR="配送异常";
        String DELING="配送中";
        String DELED="已送达";
    }

    public interface msgType{
        String PUB_TYPE="公共论坛";
        String PRI_TYPE="私人咨询";
    }
}
