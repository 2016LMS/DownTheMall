package com.gxa.miaoshacd.controller;

import com.gxa.miaoshacd.Pagess.GoodsPage;
import com.gxa.miaoshacd.entity.Goods;
import com.gxa.miaoshacd.entity.MiaoShaGoods;
import com.gxa.miaoshacd.service.GoodsService;
import com.gxa.miaoshacd.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class ProductController {

    @Autowired
    GoodsService goodsService;
    /*
    书上的注释方法
    @resource
    private GoodService goodservice
     */

    @RequestMapping("showGoods")
    @ResponseBody
    public GoodsPage showGoods(String pageNum){
        Page page = new Page();
        page.setPageNum(Integer.parseInt(pageNum));
        //Integer.parseInt(String)的作用就是将String字符类型数据转换为Integer整型数据
        page.setPageSize(3);
        //查询出goods表中的记录数
        int count = goodsService.getGoodsCount();

        page.setTotalCount(count);
        List<Goods> goods = goodsService.getAllGoodsByPage(page);

        GoodsPage goodsPage = new GoodsPage();

        goodsPage.setGoods(goods);
        goodsPage.setPage(page);

        return goodsPage;
    }

    @RequestMapping("/showGoodsDetails/{goodsId}")
    public ModelAndView showGoodsDetails(ModelAndView modelAndView, @PathVariable("goodsId") int goodsId){
//        System.out.println(goodsId);
        //根据id获取整个产品数据

        MiaoShaGoods miaoShaGoods = goodsService.getGoodsByGoodsId(goodsId);

        modelAndView.setViewName("product");
        modelAndView.addObject("miaoShaGoods",miaoShaGoods);


        //获取到商品的秒杀开始和结束时间
        long beginTime = miaoShaGoods.getBegin_time().getTime();
        long endTime = miaoShaGoods.getEnd_time().getTime();

        //当前系统时间
        long now = new Date().getTime();

        long howLongBegin = 0;
        long howLongEnd = 0;
        int status = 0;// 未开始

        if(miaoShaGoods.getMiaosha_stock() <= 0){
            status = 3;//已售罄
        }else if(beginTime > now){
            status = 0;
            //需要我们在页面中显示开始的倒计时
            howLongBegin = (beginTime - now)/1000;

        }else if(endTime <= now){
            //已经结束
            status = 1;

        }else{
            //说明活动进行时,显示离结束还有多久
            status = 2;
            howLongEnd = (endTime - now)/1000;
        }

        modelAndView.addObject("goodsSatus",status);
        modelAndView.addObject("howLongBegin",howLongBegin);
        modelAndView.addObject("howLongEnd",howLongEnd);



        return  modelAndView;

    }

}
