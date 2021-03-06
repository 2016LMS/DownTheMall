package com.gxa.miaoshacd.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.gxa.miaoshacd.entity.OrderInfo;
import com.gxa.miaoshacd.entity.OrderInfoVo;
import com.gxa.miaoshacd.service.OrderService;
import com.gxa.miaoshacd.utility.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayController {
    // 获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.url;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.format;
    String public_key = AlipayConfig.public_key;
    String signtype = AlipayConfig.signtype;

    @Autowired
    OrderService orderService;

    /**
     * 支付请求
     *
     * @param order
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/pay")
    public void pay(HttpServletRequest request, HttpServletResponse response,String orderNo) throws Exception {
      // OrderInfo orderInfo= (OrderInfo) modelAndView.getModel().get("orderInfo");

//        OrderInfo orderInfo= (OrderInfo) request.getAttribute("orderInfo");
//        System.out.println("订单信息");
//        System.out.println(orderInfo);
//        System.out.println("订单信息");
//        OrderInfo orderInfo = orderService.getOrderInfoByOrderNo(orderNo);
        System.out.println("AlipayController中的orderNo为：");
        System.out.println(orderNo);
        // 模拟从前台传来的数据
////        String orderNo = orderInfo.getOrderNo(); // 生成订单号
//        String totalAmount = String.valueOf(orderInfo.getMiaoShaGoods().getMiaosha_price()); // 支付总金额
//        String subject = "商品秒杀订单"; // 订单名称
//        String body = orderInfo.getMiaoShaGoods().getGoods().getGoods_desc(); // 商品描述

//        String orderNo = "20190624455555111";
//        String totalAmount = "299";
//        String subject = "秒杀订单"; // 订单名称
//        String body = "iphonex11";
        OrderInfoVo orderInfo=orderService.getOrderInfoByOrderNo(orderNo);
        String totalAmount=String.valueOf(orderInfo.getMiaoshaGoods().getMiaosha_price()); //将Double类型的价格转换为字符类型
        String subject = orderInfo.getGoods().getGoods_name();
        String body=orderInfo.getGoods().getGoods_desc();



        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);
        String path = request.getRequestURI();
        System.out.println(path);
        path = path.substring(0, path.lastIndexOf("/"));
        String resulturl = "http://localhost:8080/" + path + return_url; //  /alipay/return_url控制器方法里面
        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(resulturl);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderNo); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount(totalAmount); // 支付总金额
        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        String form = client.pageExecute(alipayRequest).getBody(); // 生成表单

        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form); // 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 同步跳转
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        // 返回界面
        if (signVerified) {
            String orderNo = params.get("out_trade_no");
            String alipayNo = params.get("trade_no");

//            OrderInfo orderInfo = new OrderInfo();
//            orderInfo.setOrderNo(orderNo);
//            orderInfo.setAlipayNo(alipayNo);
//            orderService.updateOrder(orderInfo);

            System.out.println("前往支付成功页面");
            mav.addObject("orderNo", orderNo);
            mav.setViewName("successReturn");
        } else {
            System.out.println("前往支付失败页面");
            mav.setViewName("failReturn");
        }
        return mav;
    }

    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/notifyurl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        System.out.printf("支付成功2");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }


        if (AlipaySignature.rsaCheckV1(params, public_key, charset, signtype)) { // 调用SDK验证签名,验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库
        } else {
            System.out.println("异步通知失败");
        }
    }

}
