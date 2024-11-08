package cn.tom.controller;

import cn.tom.entity.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller   //我是控制器和前端打交道， 会自动创建对象
@RequestMapping("/course")
public class CourseController {

    @RequestMapping("/add1.do")
    public String add1(HttpServletRequest request) {
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String score = request.getParameter("score");
        //request.setAttribute("cs", lst);
        return "course/show";   //show.jsp
    }

    @RequestMapping("/add2.do")
    public String add2(int cid, String cname, int score) {
        //request.setAttribute("cs", lst);
        System.out.println("cid=" + cid);
        System.out.println("cname=" + cname);
        System.out.println("score=" + score);
        return "/course/show";   //show.jsp
    }

    @RequestMapping("/add3.do")
    public String add3(Course course) {
        //request.setAttribute("cs", lst);
        System.out.println(course);
        return "/course/show";   //show.jsp
    }


    @RequestMapping("/show.do")
    public String show(HttpServletRequest request) {
        //request.setAttribute("cs", lst);
        return "/course/show";   //show.jsp
    }
    @RequestMapping("/del.do")
    public String del(HttpServletRequest request) {
        //request.setAttribute("cs", lst);
        return "forward:/course/show.do";  //转发
        // request.getRequestDispacther("/course/show.do")....
    }

}
