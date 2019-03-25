package com.ouqicha.europebusiness.controller.other;

import com.ouqicha.europebusiness.bean.vo.User;
import com.ouqicha.europebusiness.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;
    @RequestMapping("test")
    public String test(String name, int age){
        System.out.println(name+age);
        return "test";
    }

    @RequestMapping("login")
    public String login(){
        return "test1";
    }

    @RequestMapping("test1")
    public @ResponseBody
    User test1(String name, int age){
        System.out.println(name+age);
        List cousre = new ArrayList<String>();
        cousre.add("math");
        cousre.add("英语");
        User user  = new User();
        user.setName(name);
        user.setCourse(cousre);
        return user;
    }

    @RequestMapping("testSpring")
    public String testSpring(){
        return mainService.test();
    }
}
