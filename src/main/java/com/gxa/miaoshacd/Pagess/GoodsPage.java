package com.gxa.miaoshacd.Pagess;

import com.gxa.miaoshacd.entity.Goods;
import com.gxa.miaoshacd.utility.Page;

import java.util.List;

public class GoodsPage {

    private List<Goods> goods;

    private Page page;

    public List<Goods>  getGoods() {
        return goods;
    }

    public void setGoods(List<Goods>  goods) {
        this.goods = goods;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

