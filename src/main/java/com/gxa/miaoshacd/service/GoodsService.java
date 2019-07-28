package com.gxa.miaoshacd.service;

import com.gxa.miaoshacd.entity.Goods;
import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.utility.Page;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();
    int getGoodsCount();
    List<Goods> getAllGoodsByPage(Page page);
    MiaoShaGoods getGoodsByGoodsId(int goodsId);

    MiaoShaGoods getGoodsByMiaoShaGoodsId(String miaoShaGoodsId);

}
