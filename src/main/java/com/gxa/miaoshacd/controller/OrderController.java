package com.gxa.miaoshacd.controller;


import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.entity.OrderInfo;
import com.gxa.miaoshacd.entity.UserInfo;
import com.gxa.miaoshacd.service.GoodsService;
import com.gxa.miaoshacd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/checkout_goods/{miaoshagoodsId}")
    @ResponseBody
    public MiaoShaGoods checkOrderGoods(@PathVariable("miaoshagoodsId") int miaoshagoodsId){

        MiaoShaGoods miaoShaGoods = goodsService.getGoodsByMiaoShaGoodsId(String.valueOf(miaoshagoodsId));

        return miaoShaGoods;
    }

    @RequestMapping("/do_order")
    public ModelAndView doOrder(ModelAndView modelAndView,HttpSession session, String miaoshaGoodsId){
        //下订单   (判断登录,判断库存，减少库存，存入订单表)
        //判断登录
        UserInfo userInfo =(UserInfo) session.getAttribute("userInfo");
//        if(userInfo == null){
//            modelAndView.setViewName("sendredirect:/index.html");
//        }
            orderService.doStock(miaoshaGoodsId);

        //判断库存  select miaosha_stock from miaoshaGoods where miaoshagoods_id = miaoshaGoodsId

        //减少库存   update miaosha_goods set miaosha_stock = miaosha_stock -1 where miaoshagoods_id = 3

        //插入订单 insert into orderinfo(order_no,address_id,miaoshagoods_id,user_id,create_time,buy_count) VALUES()
       OrderInfo orderInfo = orderService.doOrderInfo(miaoshaGoodsId,userInfo);  //根据商品ID，用户信息和商品信息生成orderInfo类
       // orderService.addToOrder(orderInfo); //将生成的orderInfo存入数据库,在doOrderInfo方法里已经进行了addToOrder方法
       //设置MODEL要传递到付款页面的数据，商品名称，价格等（orderInfo）
        modelAndView.addObject("orderInfo",orderInfo); //nullable 可为空的
        String orderNo=orderInfo.getOrder_no();
        System.out.println("OrderController中的OrderNo是 ：");
        System.out.println(orderNo);

        //假设现在是立即支付  引入支付宝
        modelAndView.setViewName("redirect:/alipay/pay?orderNo="+orderNo);


        return modelAndView;


    }



}
