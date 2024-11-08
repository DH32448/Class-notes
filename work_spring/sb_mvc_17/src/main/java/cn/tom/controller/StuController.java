package cn.tom.controller;

import cn.tom.dao.ClzDao;
import cn.tom.dao.StuDao;
import cn.tom.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

@Controller  //创建控制层对象， 并且装配到 IOC 容器
//StuController bean1 = ioc.getBean(StuController.class);
@RequestMapping("/stu")
public class StuController {
    @Autowired  // 按照类型从 IOC 容器获取
    ClzDao clzDao;  //行为类的对象

    @Autowired
    StuDao stuDao;  //行为类的对象
    int curpage;  //写在这里是错误的

    public StuController() {
        System.out.println("StuController" +
                " 对象被创建了，只调用了一次");
    }
    // @GetMapping+@PostMapping = @RequestMapping
    @RequestMapping("/go2add")  //2 = to  4 = for
    // 去添加， 获取添加表单
    public String go2Add(Model model)
    {
        model.addAttribute("actmsg",
                "添加...");
        model.addAttribute("action",
                "add");

        model.addAttribute("stu",
                new Student());
        //传递班级数据
        List<Map<String, Object>> clzs = clzDao.findAll();
        model.addAttribute("clzs",
                clzs);
        return "stu/show";
    }
    @RequestMapping("/go2update")
    // 去修改， 获取修改表单
    public String go2Update(String sno,Model model)
    {
        model.addAttribute("actmsg",
                "更新...");
        model.addAttribute("action",
                "update");
        Student stu = stuDao.findOne(sno);
        model.addAttribute("stu", stu);
        List<Map<String, Object>> clzs = clzDao.findAll();
        model.addAttribute("clzs",
                clzs);
        return "stu/show";
    }

    @PostMapping("/update")
    public String update(Student t)
    {
        return "forward:/stu/page?curpage=1";
    }

    @GetMapping("/page")
    public String show(Integer curpage, Model model) {
        List<Student> list =
                stuDao.findPage((curpage - 1) * 6, 6);
        model.addAttribute("list", list);

        model.addAttribute("cp", curpage);
        return "stu/page";
    }
//  <form action="/stu/add" method="post" >
    //用于信息量较大的， 参数较多的请求
    @PostMapping("/add")
    public String add(Student t) {
        System.out.println(t);

        return "stu/ok";
        //return "forward:/stu/page?curpage=1";
    }

    @PostMapping("/del")
    public String del(String sno) {
        System.out.println(sno);

        return "stu/ok";
        //return "forward:/stu/page?curpage=1";
    }

}
