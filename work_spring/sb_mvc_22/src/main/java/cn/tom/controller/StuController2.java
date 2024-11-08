package cn.tom.controller;

import cn.tom.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/*
    private int tid;
    private String tname;
    private String phone;
    private String pwd;
    private double sal;  //工资
    private Date birth;   //生日
 */
@Controller
@RequestMapping("/stu2")
public class StuController2 {
    public StuController2() {
        System.out.println("StuController2()。。。。");
    }
    @RequestMapping("/add")
    public String add_1(Integer tid, String tname, String phone,
                        String  pwd, Double sal, Date birth) {
        System.out.println("tid=" + tid);
        System.out.println("tname=" + tname);
        System.out.println("phone=" + phone);
        System.out.println("pwd=" + pwd);
        System.out.println("sal=" + sal);
        System.out.println("birth=" + birth);
/**
 *         String tid = req.getParameter("tid");
 *         String tname = req.getParameter("tname");
 *         String phone = req.getParameter("phone");
 *         String pwd = req.getParameter("pwd");
 *         String sal = req.getParameter("sal");   Double.parse(sal);
 *         String birth = req.getParameter("birth");
 *         new SimpleDateFormat("日期格式");   // yyyy-MM-dd  , MM/dd/yyyy
 *         #<!-- new SimpleDateFormat("yyyy-MM-dd")-->
 *         spring.mvc.format.date=yyyy-MM-dd
 */
        return "ok";
    }

    @RequestMapping("/add3")   //添加  修改 接收数据走对象
    public String add_3(Teacher t) {
        System.out.println(t);

/**
 *         String tid = req.getParameter("tid");
 *         String tname = req.getParameter("tname");
 *         String phone = req.getParameter("phone");
 *         String pwd = req.getParameter("pwd");
 *         String sal = req.getParameter("sal");   Double.parse(sal);
 *         String birth = req.getParameter("birth");
 *         new SimpleDateFormat("日期格式");   // yyyy-MM-dd  , MM/dd/yyyy
 *         #<!-- new SimpleDateFormat("yyyy-MM-dd")-->
 *         spring.mvc.format.date=yyyy-MM-dd
 */
        return "ok";
    }

    //路径参数  @Path-var-i-able  path路径 variable 变量
    @GetMapping("/findById/{id}")   //Id 表示主键查找单条 记录
    public String findById(@PathVariable("id") Integer tid, HttpSession session) {
        //session.setAttribute("teacher", tname);

        Object teacher = session.getAttribute("teacher");
        System.out.println("teacher=" + teacher);
        System.out.println("tid=" + tid);
        return "ok";
    }

    //路径参数  @Path-var-i-able  path路径 variable 变量
    @GetMapping("/del/{id}/{phone}")   //Id 表示主键查找单条 记录
    public String findById(@PathVariable("id") Integer tid,
                           @PathVariable("phone") String phone) {
        System.out.println("tid=" + tid);
        System.out.println("phone=" + phone);
        return "ok";
    }

}
