package com.gxa.miaoshacd.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gxa.miaoshacd.entity.UserInfo;
import com.gxa.miaoshacd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired  //@Autowired是用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法注入所需的外部资源。
    UserService userService;

    @RequestMapping("/do_checkUserName")
    @ResponseBody
    public boolean checkRegisterName(String userName){

        boolean result = userService.checkUserName(userName);
        return result;
    }
    @RequestMapping("/do_regist")
    //@ResponseBody
    public void RegistController( UserInfo userInfo,HttpServletResponse resp1)throws Exception{
//        System.out.println(userInfo);
//        System.out.println(userInfo.getUserName());
        boolean result2=userService.registUser(userInfo);
       // modelAndView.addObject("result3",result2);
        //webRequest.setAttribute("result2",result2);
        //return result2;
        if (result2 == true){
            //return "product";
            resp1.sendRedirect("http://localhost:8080/index_show.html");

        }else{
            resp1.sendRedirect("http://localhost:8080/failLogin.html");
        }
    }

    @RequestMapping("/do_login")
    public void loginController(UserInfo userInfo, HttpServletResponse resp, HttpServletRequest request) throws Exception{
//        System.out.println(userInfo.getUserName());
//        System.out.println(userInfo.getUserPwd());
//        System.out.println(userInfo.getUserEmail());
        UserInfo result3 = userService.userLogin(userInfo);
        if (result3 != null){
            request.getSession().setAttribute("userInfo",userInfo);
            resp.sendRedirect("http://localhost:8080/index_show.html");

        }else{
            resp.sendRedirect("http://localhost:8080/failLogin.html");
        }
    }

    @RequestMapping("/do_update")
    public void updateController(UserInfo userInfo, HttpServletResponse resp)throws Exception{
        boolean result5=userService.userUpdate(userInfo);
        if (result5 == false){
            resp.sendRedirect("http://localhost:8080/index.html");
        }else {
            resp.sendRedirect("http://localhost:8080/failRegist.html");
        }

    }

    @RequestMapping("do_delete")
    public void deleteController(UserInfo userInfo, HttpServletResponse resp)throws  Exception{
        boolean result6 = userService.deleteUser(userInfo);
        if(result6 == true){
            resp.sendRedirect("http://localhost:8080/index.html");
        }else{
            resp.sendRedirect("http://localhost:8080/failRegist.html");
        }
    }
    @ResponseBody
    @RequestMapping("/do_checkLogin")
    public UserInfo checkLoginContrller(HttpServletRequest request){
       UserInfo info = (UserInfo) request.getSession().getAttribute("userInfo");
       return info;
    }

}
