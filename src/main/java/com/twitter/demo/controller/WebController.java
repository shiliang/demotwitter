package com.twitter.demo.controller;/*
 * @program:com.twitter.demo.controller
 * @description:网站控制器
 * @author:shiliang
 * @create:2018-06-05 14:11
 * */

import com.twitter.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //传对象到前台表单
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("username", "hello");

        User user = new User();
        user.setPassword("123");
        user.setUsername("fwrf");
        map.put("userInfo",user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute User user) {
        //调用服务验证登录并实现跳转
        String username = user.getUsername();
        String password = user.getPassword();
        return username+"__"+password;
    }


}
