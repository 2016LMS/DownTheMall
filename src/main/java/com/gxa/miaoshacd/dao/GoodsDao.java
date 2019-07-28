package com.gxa.miaoshacd.dao;

import com.gxa.miaoshacd.entity.Goods;
import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.utility.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
//@Repository用于标注数据访问组件，即DAO组件
public interface GoodsDao {
    List<Goods> selectGoods();
    int selectGoodsCount();
    List<Goods> selectGoodsByPage(Page page);
    MiaoShaGoods selectMiaoShaGoodsByGoodsId(int goodsId);

    MiaoShaGoods selectMiaoShaGoodsByMiaoShaGoodsId(String miaoshaGoodsId);

}
