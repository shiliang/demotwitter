package com.twitter.demo.controller;/*
 * @program:com.twitter.demo.controller
 * @description:登录控制器
 * @author:shiliang
 * @create:2018-07-24 18:49
 * */

import com.twitter.demo.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //传对象到前台表单
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("username", "hello");

        User user = new User();
        user.setPassword("password");
        user.setUsername("username");
        map.put("userInfo",user);
        return "login";
    }

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute User user) {
        //调用服务验证登录并实现跳转
        String username = user.getUsername();
        String password = user.getPassword();
        logger.info(username+password);
        return "index";
    }
}
