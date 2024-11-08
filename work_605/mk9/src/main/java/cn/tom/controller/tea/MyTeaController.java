package cn.tom.controller.tea;

import cn.tom.dao.*;
import cn.tom.entity.*;
import cn.tom.service.MarkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Controller
@RequestMapping("/tea")
public class MyTeaController {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    TaskMapper taskMapper;
    @Autowired(required = false)
    ClzMapper clzMapper;
    @Autowired(required = false)
    CourseMapper courseMapper;
    @Autowired(required = false)
    MarkMapper markMapper;

    @RequestMapping("/go2updateMe")  //tea/updatePwd
    public String go2UpdateMe(HttpSession session, Model model) {
        //重点： 从 session 获取当前登录的教师的对象， 对象里面有教师的 UID 主键及电话号码
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }
        //从数据库查询该用户
        User u = userMapper.findByUid(user.getUid());
        model.addAttribute("u", u);
        return "tea/updateMe";
    }
//    /tea/updateMe
    @RequestMapping("/updateMe")  //tea/updateMe
    public String go2UpdateMe(User newUser, HttpSession session, Model model) {
        //重点： 从 session 获取当前登录的教师的对象， 对象里面有教师的 UID 主键及电话号码
        System.out.println("更新密码：" + newUser);
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }
        //重点， UID 从 session 对象获取
        newUser.setUid(user.getUid());

        int x = userMapper.updatePwd(newUser);

        if (x==1) {
            model.addAttribute("u", newUser);
            model.addAttribute("msg", "更新完毕!!!");
        } else {
            model.addAttribute("u", user);
            model.addAttribute("msg", "更新失败 ....");
        }
        return "tea/updateMe";
    }
    @RequestMapping("/findMyTask")
    public String findMyTask(HttpSession session, Model model) {
        //重点： 从 session 获取当前登录的教师的对象， 对象里面有教师的 UID 主键及电话号码
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }
        List<TaskInfo> tasks = taskMapper.findByTid(user.getUid());
        model.addAttribute("tasks", tasks);
        return "tea/myTask";
    }
    @RequestMapping("/findMark")
    public String findMark(String clzno, String cno, Model model) {
        //clzno  班级编号， 获取该班级的所有学生
        //cno 课程号， 录入哪一门的课程
        System.out.println("findMark clzno=" + clzno);
        System.out.println("findMark cno=" + cno);

//        Clz clz = clzService.findOne(clzno);
//        Course cour = courseService.findOne(cno);
//        mks = markService.findMark(cno, clzno);
//        model.addAttribute("clz", clz);
//        model.addAttribute("cour", cour);
//        model.addAttribute("mks", mks);
        return "tea/addMark";
    }
    @RequestMapping("/addMark")
    public String addMark(Mark mark, String clzno, Model model) {
        System.out.println("Mark=" + mark);
        System.out.println("clzno=" + clzno);
        //Mark 类里面没有 clzno 班级编号
        System.out.println("addMark mark=" + mark);
        if (mark.getId() ==0) {  //主键是 0 ， 表示 t_mark 原先没有这条记录， 添加
            markMapper.add(mark);
        } else  {
            markMapper.update(mark);
        }
        //转发到录入分数的界面， 本来需要自己带上 clzno 和cno
        //做请求转发时， 请求还是原来那个请求， 所以不用自己带参数了， 带了可能还会出错的
        // public String findMark(String clzno, String cno, Model model)
        //  System.out.println("forward:/tea/findMark?clzno=" + clzno + "&cno=" + mark.getCno());
        //return "forward:/tea/findMark?clzno=" + clzno + "&cno=" + mark.getCno();
        return "forward:/tea/findMark";
    }
}
