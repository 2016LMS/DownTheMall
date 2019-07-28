package com.gxa.miaoshacd.service;

import com.gxa.miaoshacd.entity.OrderInfo;
import com.gxa.miaoshacd.entity.OrderInfoVo;
import com.gxa.miaoshacd.entity.UserInfo;

public interface OrderService {

    /**
     * 减少库存
     */
    void doStock(String miaoshaGoodsId);

    /**
     * 添加订单
     */
    void addToOrder(OrderInfo orderInfo);

      OrderInfo doOrderInfo(String miaoshaGoodsId, UserInfo userInfo);

      OrderInfoVo getOrderInfoByOrderNo(String orderNo);


}
