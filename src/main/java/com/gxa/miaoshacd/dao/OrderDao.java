package com.gxa.miaoshacd.dao;


import com.gxa.miaoshacd.entity.OrderInfo;
import com.gxa.miaoshacd.entity.OrderInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {

    void updateMiaoshaGoodsStock(String miaoshaGoodsId);

    void insertOrderInfo(OrderInfo orderInfo);
    OrderInfoVo selectOrderInfoByOrderNo(String orderNo);
}
