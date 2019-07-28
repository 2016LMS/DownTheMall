package com.gxa.miaoshacd.service.impl;

import com.gxa.miaoshacd.dao.GoodsDao;
import com.gxa.miaoshacd.dao.OrderDao;
import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.entity.OrderInfo;
import com.gxa.miaoshacd.entity.OrderInfoVo;
import com.gxa.miaoshacd.entity.UserInfo;
import com.gxa.miaoshacd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    GoodsDao goodsDao;


    @Override
    public void doStock(String miaoshaGoodsId) {
        //操作数据库，库存miaosha_stock-1
        orderDao.updateMiaoshaGoodsStock(miaoshaGoodsId);
    }

    @Override
    public void addToOrder(OrderInfo orderInfo) {

        orderDao.insertOrderInfo(orderInfo);
    }

    @Override
    public OrderInfoVo getOrderInfoByOrderNo(String orderNo) {
        OrderInfoVo orderInfoVo= orderDao.selectOrderInfoByOrderNo(orderNo);
//        select * from orderinfo o join miaosha_goods m on o.miaoshagoods_id = m.miaoshagoods_id join goods  g on g.goods_id = m.goods_id where order_no =
        return orderInfoVo;
    }

    @Transactional
    @Override
    public OrderInfo doOrderInfo(String miaoshaGoodsId, UserInfo userInfo){
        doStock(miaoshaGoodsId);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder_no(new Date().getTime()+miaoshaGoodsId);//设置订单的ID

        MiaoShaGoods miaoShaGoods = goodsDao.selectMiaoShaGoodsByMiaoShaGoodsId(miaoshaGoodsId);

        orderInfo.setMiaoShaGoods(miaoShaGoods);

        orderInfo.setUserInfo(userInfo);

        orderInfo.setBuy_count(1);   //默认一件，每次结账页面只有一件商品，而不是一个购物车

//        orderInfo.setCreate_time(new Date());

        addToOrder(orderInfo);      //这里已经存入数据库了！！！

        return  orderInfo;

    }
}
