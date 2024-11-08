package cn.tom.controller;

import cn.tom.entity.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/t")
public class TeacherController {
    @RequestMapping("/go2add")
    public String  go2add() {   //添加修改， 需要填写 Form, 第一次去添加，显示表单
        return "teacher/add";
    }
    //JavaWEB
    @RequestMapping("/doAdd")
    public String  add(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session //request.getSession
                       ) throws Exception {

        String tname = request.getParameter("tname");
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String sal = request.getParameter("sal");   //double
        String birth = request.getParameter("birth");   //Date
//   private double sal;
//    private Date birth;
        Teacher teacher = new Teacher();
        teacher.setTname(tname);
        teacher.setPhone(phone);
        teacher.setPwd("pwd");
        teacher.setSalary(Double.parseDouble(sal));  //字符串转小数
        //字符串转日期对象
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        Date d  = simpleDateFormat.parse(birth);
        teacher.setBirthday(d);
        System.out.println(teacher);
        request.setAttribute("r", teacher);
        return "1";
    }
    @RequestMapping("/doAdd1")
    public String add1(String tname,
                       String phone,
                       String pwd,
                       Double sal,
                       Date birth ,
                       HttpServletResponse response,
                       Model model) {
        //      SimpleDateFormat simpleDateFormat =
        //                new SimpleDateFormat("yyyy-MM-dd");
        //        Date d  = simpleDateFormat.parse(birth);
        System.out.println("单个参数绑定！！！！");
        Teacher teacher = new Teacher();
        teacher.setTname(tname);

        teacher.setPhone(phone);
        teacher.setPwd(pwd);

        teacher.setSalary(sal);

        teacher.setBirthday(birth);
        System.out.println(teacher);
        model.addAttribute("r", teacher);
        return "1";
    }
    @RequestMapping("/doAdd2")
    public String add1(Teacher teacher ,
                        HttpServletRequest request,
                        HttpSession session,
                       Model model) {
        System.out.println("对象参数绑定！！！！");
        System.out.println(teacher);
        model.addAttribute("r", teacher);
        return "1";   //1.html
    }
}
