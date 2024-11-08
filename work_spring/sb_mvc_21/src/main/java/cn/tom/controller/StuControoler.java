package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StuControoler {

//   <a href='/stu/del?sno=100 > 删除 </a>
    @GetMapping("/del")
    public String del(String sno) {
        System.out.println( "sno=" +sno);
        return "r";
    }

    //   <a href='/stu/del/100 > 删除 </a>   Restful
    //   根据 ID 查找， 删除， 更新之类都这样写
    //  Path 路径  Variable 变量
    @GetMapping("/del2/{sno}")
    public String del2(@PathVariable("sno") String sno) {
        System.out.println( "del2 sno=" +sno);
        return "r";
    }
}
