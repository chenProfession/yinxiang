package com.yiinxiang.enums;

import lombok.Getter;

/**
 * @program: result code
 * @Description: To show the message of result according to the code
 * @Author: Mr.Cheng
 * @Date: 2019/3/29 9:11 AM
*/

@Getter
public enum ResultEnums {

    SUCCESS(0, "success"),

    FAILURE(2, "failure"),

    PARAM_ERROR(1, "incorrect parameter"),

    CUSTOMER_NOT_EXIST(10, "Customer does not exist"),

    CUSTOMER_NOT_FOUND_BY_NAME(11, "Customer can not find by name"),

    CUSTOMER_NOT_FOUND_BY_PHONE(12, "Customer can not find by phone"),

    PRODUCT_STOCK_ERROR(13, "商品库存不正确"),

    ORDER_NOT_EXIST(14, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(15, "订单详情不存在"),

    ORDER_STATUS_ERROR(16, "订单状态不正确"),

    ORDER_UPDATE_FAIL(17, "订单更新失败"),

    ORDER_DETAIL_EMPTY(18, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(19, "订单支付状态不正确"),

    CART_EMPTY(20, "购物车为空"),

    ORDER_OWNER_ERROR(21, "该订单不属于当前用户"),

    WECHAT_MP_ERROR(22, "微信公众账号方面错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(23, "微信支付异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(24, "订单取消成功"),

    ORDER_FINISH_SUCCESS(25, "订单完结成功"),

    PRODUCT_STATUS_ERROR(26, "商品状态不正确"),

    LOGIN_FAIL(27, "login failed, username or password is incorrect"),

    PRODUCT_CREATE_SUCCESS(28, "crate product successfully"),

    PRODUCT_CREATE_ERROR(29, "crate product failed"),

    LOGOUT_SUCCESS(30, "logout success"),

    REGISTER_SUCCESS(31, "register success"),

    NONE(32, "none")
    ;

    private Integer code;

    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
