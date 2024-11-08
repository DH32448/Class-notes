package com.example.demo.controller;

import com.example.demo.dao.ClzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    //如何证明被new
    //ClzDao clzDao new ClzDao 这段代码成为历史
    //从ioc.getBean(cizDao.class)获取到clzDao
    //Auto 自动 wire绑定
    @Autowired//    private ClzDao clzDao = ioc.getBean(ClzDao.class);
    private ClzDao clzDao;

    public HelloController(){
        System.out.println("Hello创建对象");
    }
    @RequestMapping("/hi.do")
    public String doHi(){
        return "hi";
    }
}
