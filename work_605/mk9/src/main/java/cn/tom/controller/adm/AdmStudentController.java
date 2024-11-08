package cn.tom.controller.adm;

import cn.tom.dao.ClzMapper;
import cn.tom.dao.UserMapper;

import cn.tom.entity.Clz;
import cn.tom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adm/stu")
public class AdmStudentController {
    // 注意学生 和教师 Controller 用的是 userDao(userMapper)
    @Autowired
    UserMapper userMapper;
    // 班级下拉框需要班级DAO
    @Autowired
    ClzMapper clzMapper;
    //添加页面
    @RequestMapping("/go2Add")    //adm/stu/go2Add
    public String  go2Add(Model model) {
        model.addAttribute("action", "Add");
        // 注意： 无参数构造方法， 重写一下， 设置初始值
        User user = new User();
        user.setRole(1);    //学生角色 5
        model.addAttribute("user", user);
        return "forward:/adm/stu/show";
    }
    //获取添加数据， 并写到数据库
    @RequestMapping("/doAdd")
    public String  doAdd(User u) {
        //添加到数据库， 转发到学生页面
        System.out.println("Add Student=" + u);
        u.setRole(1);
        userMapper.add(u);
        return "forward:/adm/stu/show";
    }
    //列表
    @RequestMapping("/show")
    public String  doShow(Model model) {
        //获取学生 role=1 数据， 显示页面
        List<Clz> clzs = clzMapper.findAll();
        model.addAttribute("clzs", clzs);
        List<User> lst = userMapper.findByRole(1);
        System.out.println("show students=" + lst);
        model.addAttribute("stus", lst);
        return "adm/student/show";
    }
    //获取修改页面
    @RequestMapping("/go2Update")
    public String  go2Update(Model model, int uid) {
        //根据主键获取修改记录, 并页面表单上
        System.out.println("update student uid=" + uid);
        model.addAttribute("action", "Update");
        User  user = userMapper.findByUid(uid);
        model.addAttribute("user", user);
        System.out.println("update user=" + user);
        return "forward:/adm/stu/show";
    }
    //获取更新数据， 并写到数据库
    @RequestMapping("/doUpdate")
    public String  doUpdate(User user) {
        //更新数据库数， 转发到学生页面
        user.setRole(1);
        System.out.println("update student=" + user);
        userMapper.update(user);
        return "forward:/adm/stu/show";
    }
    //删除
    @RequestMapping("/del")
    public String  doDel(int uid, Model model) {
        //更新数据库数， 转发到学生页面
        System.out.println("del uid=" + uid);
        userMapper.remove(uid);
        User user = new User();
        user.setRole(1);    //学生角色 5
        model.addAttribute("user", user);
        userMapper.remove(uid);
        return "forward:/adm/stu/show";
    }
}
