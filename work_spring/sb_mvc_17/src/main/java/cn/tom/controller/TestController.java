package cn.tom.controller;

import cn.tom.dao.ClzDao;
import cn.tom.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller   //控制器
@RequestMapping("/hi")
public class TestController {
    @Autowired    //ioc.getBean(ClzDao.class)
    ClzDao clzDao;

    @Autowired    //ioc.getBean(CourseDao.class)
    CourseDao courseDao;

    @RequestMapping("/11")
    public String do1(HttpServletRequest request) {
        // Model
        List<Map<String, Object>> all = clzDao.findAll();

        // 把  Model（all） 和视图  1.html 绑定起来
        request.setAttribute("clzs", all);
        return "1";  //1.html
    }

    @RequestMapping("/22")
    public String do2(Model model) {
        List<Map<String, Object>> all = clzDao.findAll();
        List<Map<String, Object>> all2 = courseDao.findAll();

        model.addAttribute("clzs", all);
        model.addAttribute("courses", all2);
        model.addAttribute("hello",
                "<h2 style='color:red'>HELLO</h2>");
        return "2";   //2.html
    }

}
