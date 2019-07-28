package com.gxa.miaoshacd.entity;

import java.util.Date;

public class OrderInfo {

    private  int order_id;

    private  String order_no;

//    private

    private MiaoShaGoods miaoShaGoods; //订单类包含了秒杀类，用秒杀类来接受秒杀类的属性

    private UserInfo userInfo;     //订单类包含了用户信息类，用来接受用户信息的属性

    private Date create_time;

    private Date pay_time;

    private int buy_count;

    private  Date order_pay_no;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public MiaoShaGoods getMiaoShaGoods() {
        return miaoShaGoods;
    }

    public void setMiaoShaGoods(MiaoShaGoods miaoShaGoods) {
        this.miaoShaGoods = miaoShaGoods;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public int getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(int buy_count) {
        this.buy_count = buy_count;
    }

    public Date getOrder_pay_no() {
        return order_pay_no;
    }

    public void setOrder_pay_no(Date order_pay_no) {
        this.order_pay_no = order_pay_no;
    }
}
