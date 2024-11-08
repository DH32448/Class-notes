package cn.tom.controller;

import cn.tom.dao.StuDao;
import cn.tom.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    StuDao stuDao;
    // 去登录， 获取登录的页面
    @GetMapping("/go2login")
    public String go2Logoin() {

        return "user/login";
    }


    @PostMapping("/login")
    public String login(String phone, String pwd,
                        HttpServletRequest request) {
        //如果登录成功
        System.out.println("phone=" + phone);
        System.out.println("pwd=" + pwd);
        HttpSession session = request.getSession();
        System.out.println("Login session id=" + session.getId());
        Stu stu = stuDao.findOneByPhone( phone );
        if (stu == null) {
            request.setAttribute("loginmsg", "登录失败-账号不存在");
            return "/user/login";
        }
        if (pwd!=null && pwd.equals(stu.getPwd())){
            //登录成功， 每个对应一个 session 对象
            stu.setPwd("");
            session.setAttribute("DL", stu);  //设置登录成功的标识
            request.setAttribute("loginmsg", "登录-登录成功");
            return "/user/login";
        }
        request.setAttribute("loginmsg", "登录失败-密码错误");
        return "/user/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        //HttpSession session = request.getSession();
        System.out.println("销毁对象");
        session.invalidate();
        model.addAttribute("loginmsg", "退出， 请重登录");
        return "/user/login";
    }
}
