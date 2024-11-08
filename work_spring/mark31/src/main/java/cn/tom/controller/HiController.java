package cn.tom.controller;

import cn.tom.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller  //表示我是一个控制层， 并且SpringBoot会创建HiController 类型对象
@RequestMapping("/hi")
public class HiController {
    private static List<Teacher> lstTeachers = new ArrayList<>();
    private static int  id=0;

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("ts", lstTeachers);
        return "teacher/show";
    }
    @RequestMapping("/go2Add")
    public String go2Add(Model model) {
        return "teacher/add";
    }
    @RequestMapping("/doAdd")
    public String doAdd(Teacher teacher) {
        id ++;
        teacher.setTid(id);
        lstTeachers.add(teacher);
        System.out.println(lstTeachers);  // []
        return "forward:/hi/show";
        //转发： 服务器内部发起一个请求， 目的就是调用 show 方法而已。
    }
}
