package com.furniture.shopping.exception;

/**
 * @author ${USER}
 * 描述：     异常枚举
 * @date ${DATE} ${TIME}
 */
public enum FurnitureExceptionEnum {
    USER_NO_EXISTS(10001,"用户不存在"),
    PASS_WORD_ERROR(10002,"密码错误"),
    USER_NO_EMPTY(10003,"账号为空"),
    PASS_WORD_EMPTY(10004,"密码为空"),
    INSERT_ERROR(10005,"新增失败"),
    DELETE_ERROR(10006,"删除失败"),
    USER_UNIQUE(10008,"唯一标识有误"),
    UPDATE_ERROR(10009,"更新失败"),
    ORDER_ERR_STATE(10010,"订单状态不符"),
    DEL_ERR_STATE(10011,"配送单状态不符"),
    PRO_NO_ENOUGH(10012,"商品库存不足"),
    ORDER_NEED_PRO(10013,"需要选择商品"),
    GENE_ORDER_ERR(10014,"生成订单失败"),

    ROLE_NO_EMPTY(10015, "请选择角色"),
    ROLE_SEL_ERROR(10016, "用户与身份不匹配"),
    USER_STATUS_ERROR(10015, "此账号正在审核中"),

    SYSTEM_ERROR(20000, "系统异常，请从控制台或日志中查看具体错误信息");
    /**
     * 异常码
     */
    Integer code;
    /**
     * 异常信息
     */
    String msg;

    FurnitureExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
