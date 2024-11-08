package cn.tom.controller.stu;

import cn.tom.dao.MarkMapper;
import cn.tom.dao.TaskMapper;
import cn.tom.dao.UserMapper;
import cn.tom.entity.MarkInfo;
import cn.tom.entity.TaskInfo;
import cn.tom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class MyStuController {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    TaskMapper taskMapper;
    @Autowired(required = false)
    MarkMapper markMapper;

    @RequestMapping("/go2updateMe")  //tea/updatePwd
    public String go2UpdateMe(HttpSession session, Model model) {
        //重点： 从 session 获取当前登录的学生的对象， 对象里面有学生的 UID 主键及电话号码
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }
        //从数据库查询该用户  //重点， UID 从 session 对象获取
        User u = userMapper.findByUid(user.getUid());
        model.addAttribute("u", u);
        return "stu/updateMe";
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
        return "stu/updateMe";
    }

    //查询我的课程
    @RequestMapping("/findMyCourse")
    public String findMyCourse(HttpSession session, Model model) {
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }

        List<TaskInfo> tasks = taskMapper.findByClzno(user.getClzno());
        model.addAttribute("tasks", tasks);
        return "stu/myTask";

    }
    //查询我的分数
    @RequestMapping("/findMyMark")
    public String  findMyMark(HttpSession session, Model model) {
        Object who = session.getAttribute("who");
        //向下转型
        User user = (User)who;
        if (user == null) {
            //如果是空指针， 后台的 session 失效了， 意味没有登录
            //转发到首页， 并提示去登录
            model.addAttribute("err", "未登录， 请登录后才能修改本人密码");
            return "main";
        }
        // 注意 t_mark.sno  == t_user.phone
        List<MarkInfo> mks = markMapper.findBySno(user.getPhone());
        model.addAttribute("mks", mks);
        return "stu/myMark";
    }
}
