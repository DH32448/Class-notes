package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller   //我是控制器和前端打交道， 会自动创建对象
@RequestMapping("/user")
public class UserController {
    //第一步， 获取添加的表单
    @RequestMapping("/go2Add.do")
    public String go2Add(HttpServletRequest req) {
        return "user/add";
    }

    //第二步， 获取表单数据， 保存到数据库
    @RequestMapping("/add.do")   // clz/add.do
    public String add(User user, HttpServletRequest req) {
        System.out.println("user=" + user);
        //判断手机号是不是重复， 手机号创建 【唯一索引】， 报异常
        try {
            userDao.add(user);
        } catch (Exception e) {
            req.setAttribute("msg", "添加失败:" + e.getMessage());
            return "/user/adddok";
        }
        req.setAttribute("msg", "添加成功");
        return "/user/adddok";
    }
}
