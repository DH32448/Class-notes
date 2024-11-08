package cn.tom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //表示我是一个控制层， 并且SpringBoot会创建TestController 类型对象
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/1")
    public String do1() {
        return "1";
    }
    @RequestMapping("/hi")
    public String doHi() {
        return "1";
    }
    @RequestMapping("/clz/go2Add")
    public String doClzShow(Model model) {
        model.addAttribute("name", "卢世泉");
        return "clz/add";
    }
}
