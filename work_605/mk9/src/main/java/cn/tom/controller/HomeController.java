package cn.tom.controller;

import cn.tom.dao.UserMapper;
import cn.tom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/main")
    public String doMain(HttpSession session ,Model model) {
        model.addAttribute("err", "请登录!!!");
        return "main";
    }
    ///home/logout
    @RequestMapping("/logout")
    public String doLogout(HttpSession session, Model model) {
        session.invalidate(); //对应的浏览器的 sesion 对象销毁
        //session.setAttribute("who", u);   who对应也被销毁
        model.addAttribute("err", "退出，请登录!!!");
        return "main";
    }

//   /home/login
// model.addAttribute("err",  登录状态的信息）
    @RequestMapping("/login")
    public String doLogin(HttpSession session ,Model model,
                          String phone, String pwd) {
        // 根据 phone 查找 t_user 获取 User 对象
        // 如果 User 对象是 null 表示账户不存在
        // 比对密码
       System.out.println("doLogin:  phone=" + phone + "    pwd=" + pwd);
       User u = userMapper.findOneByPhone(phone);//去查数据库
        System.out.println("u=" + u);
        if (u == null) {
            System.out.println("数据库里面没有该手机账户");
            model.addAttribute("err","数据库里面没有该手机号账户" );
            return "main";
        }
        // 比对密码
        if (pwd!=null  && pwd.equals(u.getPwd())) {
            System.out.println("登录成功");
            model.addAttribute("err","登录成功");
            session.setAttribute("who", u);
        } else {
            System.out.println("登录失败， 密码不对");
            model.addAttribute("err","登录失败， 密码不对");
            return "main";
        }
        return "main"; //登录成功
    }

}
