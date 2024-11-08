package cn.tom.controller;

import cn.tom.dao.ClzDao;
import cn.tom.dao.CourseMapper;
import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseMapper mapper; //从 IOC 容器取出CourseMapper 这个类型对象

    @RequestMapping("/show")
    public String findAll(Model model) {
        //ClzDao clzDao = new ClzDao();
        List<Course> cos = mapper.findAll();
        System.out.println("cos=" + cos);
        model.addAttribute("cos", cos);
        return "course/show";
    }
}
