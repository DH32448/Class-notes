package cn.tom.controller;

import cn.tom.dao.ClzDao;
import cn.tom.entity.Clz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//     /clz/showx
@Controller
@RequestMapping("/clz")
public class ClzController {
    @Autowired
    ClzDao clzDao; //从 IOC 容器取出clzDao 这个类型对象

    public ClzController() {  //ClzContoller.class.newIntance();
        System.out.println("ClzController() 被调用， 意味对象创建了");
    }

    @RequestMapping("/showx")
    public String findAll(Model model) {
        //ClzDao clzDao = new ClzDao();
        List<Clz> clzs = clzDao.findAll();
        System.out.println("clzs=" + clzs);
        model.addAttribute("cs", clzs);
        //requeest.setAttribute("clzs", clzs);
        return "clz/show";
    }
}
