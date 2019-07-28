package com.gxa.miaoshacd.service.impl;

import com.gxa.miaoshacd.dao.GoodsDao;
import com.gxa.miaoshacd.entity.Goods;
import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.service.GoodsService;
import com.gxa.miaoshacd.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {

        return goodsDao.selectGoods();
    }

    @Override
    public int getGoodsCount() {
        return  goodsDao.selectGoodsCount();
    }

    @Override
    public List<Goods> getAllGoodsByPage(Page page) {

        return goodsDao.selectGoodsByPage(page);

    }

    @Override
    public MiaoShaGoods getGoodsByGoodsId(int goodsId) {

        return goodsDao.selectMiaoShaGoodsByGoodsId(goodsId);
    }

    @Override
    public MiaoShaGoods getGoodsByMiaoShaGoodsId(String miaoShaGoodsId) {
        return goodsDao.selectMiaoShaGoodsByMiaoShaGoodsId(miaoShaGoodsId);
    }
}
