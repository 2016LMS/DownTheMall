package com.gxa.miaoshacd.entity;

import java.util.Date;

public class MiaoShaGoods {
    private int miaoshagoods_id;

    private Goods goods;

    private double miaosha_price;

    private int miaosha_stock;

    private Date begin_time;

    private Date end_time;

    public int getMiaoshagoods_id() {
        return miaoshagoods_id;
    }

    public void setMiaoshagoods_id(int miaoshagoods_id) {
        this.miaoshagoods_id = miaoshagoods_id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double getMiaosha_price() {
        return miaosha_price;
    }

    public void setMiaosha_price(double miaosha_price) {
        this.miaosha_price = miaosha_price;
    }

    public int getMiaosha_stock() {
        return miaosha_stock;
    }

    public void setMiaosha_stock(int miaosha_stock) {
        this.miaosha_stock = miaosha_stock;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
