package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/a")
    public String doA() {
        return "a";
    }
    @RequestMapping("/b")
    public String doB(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("B sessionid =" + id );
        //session.setAttribute("loginok", username );
        Object username = session.getAttribute("loginok");
        System.out.println("登录：" +  username);

        return "b";
    }
    @RequestMapping("/c")
    public String doC(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("C sessionid =" + id );
        //session.setAttribute("loginok", username );
        Object username = session.getAttribute("loginok");
        System.out.println("登录：" +  username);
        return "c";
    }

    @RequestMapping("/d")
    public String doC(HttpServletRequest request,
                      HttpServletResponse resp) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("D sessionid =" + id );
        Cookie c = new Cookie("name", "tom");
        Date d = new Date();
        System.out.println(d.getTime());
        Cookie c2 = new Cookie("timex",  "" + d.getTime());
        resp.addCookie(c);
        resp.addCookie(c2);
        //session.setAttribute("loginok", username );
        Object username = session.getAttribute("loginok");
        System.out.println("登录：" +  username);
        return "d";
    }
    //退出登录

    @RequestMapping("/e")
    public String doE(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println(" sessionid =" + id );
        //session.setAttribute("loginok", username );
        session.invalidate();  //销毁 对应的ID 的  session 对象，
        return "e";
    }


}
