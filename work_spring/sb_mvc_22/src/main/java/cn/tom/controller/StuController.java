package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    private int tid;
    private String tname;
    private String phone;
    private String pwd;
    private double sal;  //工资
    private Date birth;   //生日
 */
@Controller
@RequestMapping("/stu")
public class StuController {
    public StuController() {
        System.out.println("StuController()。。。。");
    }
    @RequestMapping("add")
    public String add_1(HttpServletRequest req, HttpSession session) {
        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");
        String phone = req.getParameter("phone");
        String pwd = req.getParameter("pwd");
        String sal = req.getParameter("sal");
        String birth = req.getParameter("birth");

        System.out.println("tid=" + tid);
        System.out.println("tname=" + tname);
        System.out.println("phone=" + phone);
        System.out.println("pwd=" + pwd);
        System.out.println("sal=" + sal);
        System.out.println("birth=" + birth);
        session.setAttribute("teacher", tname);

        return "ok";
    }

    @GetMapping("/add2")   //? GET   接收 ?tid=100&birth=2004-12-20
    public String add_2(HttpServletRequest req) {
        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");
        String phone = req.getParameter("phone");
        String pwd = req.getParameter("pwd");
        String sal = req.getParameter("sal");
        String birth = req.getParameter("birth");

        System.out.println("tid=" + tid);
        System.out.println("tname=" + tname);
        System.out.println("phone=" + phone);
        System.out.println("pwd=" + pwd);
        System.out.println("sal=" + sal);
        System.out.println("birth=" + birth);

        return "ok";
    }

    @PostMapping("/add3")   //? GET   接收 ?tid=100&birth=2004-12-20
    public String add_3(HttpServletRequest req) {
        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");
        String phone = req.getParameter("phone");
        String pwd = req.getParameter("pwd");
        String sal = req.getParameter("sal");
        String birth = req.getParameter("birth");

        System.out.println("tid=" + tid);
        System.out.println("tname=" + tname);
        System.out.println("phone=" + phone);
        System.out.println("pwd=" + pwd);
        System.out.println("sal=" + sal);
        System.out.println("birth=" + birth);

        return "ok";
    }
}
