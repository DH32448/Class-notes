package cn.tom.controller.adm;

import cn.tom.dao.CourseMapper;
import cn.tom.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//课程管理
@Controller
@RequestMapping("/adm/course")
public class AdmCourseController {
    @Autowired(required = false)
    CourseMapper courseMapper;
    //添加页面
    @RequestMapping("/go2Add")    //adm/course/go2Add
    public String  go2Add(Model model) {
        model.addAttribute("action", "Add");
        // 注意： 无参数构造方法， 重写一下， 设置初始值
        Course c = new Course();
        model.addAttribute("course", c);
        return "forward:/adm/course/show";
    }
    //获取添加数据， 并写到数据库
    @RequestMapping("/doAdd")
    public String  doAdd(Course course) {
        //添加到数据库， 转发到课程页面
        System.out.println("Add Course=" + course);
            courseMapper.add(course);
        return "forward:/adm/course/show";
    }
    //列表
    @RequestMapping("/show")
    public String  doShow(Model model) {
        //获取课程数据， 显示页面
        List<Course> lst = courseMapper.findAll();
        System.out.println("show courses=" + lst);
        model.addAttribute("cs", lst);
        return "adm/course/show";
    }

    //获取修改页面
    @RequestMapping("/go2Update")
    public String  go2Update(Model model,String cno) {
        //根据主键获取修改记录, 并页面表单上

        System.out.println("update cno=" + cno);
        model.addAttribute("action", "Update");
        Course c = courseMapper.findOne(cno);
        model.addAttribute("course", c);
        System.out.println("update c=" + c);
        return "forward:/adm/course/show";
    }
    //获取更新数据， 并写到数据库
    @RequestMapping("/doUpdate")
    public String  doUpdate(Course course) {
        //更新数据库数， 转发到班级页面
        System.out.println("update Course=" + course);
        courseMapper.update(course);
        return "forward:/adm/course/show";
    }

    //删除
    @RequestMapping("/del")    //adm/clz/doUpdate
    public String  doDel(String cno, Model model) {
        //更新数据库数， 转发到班级页面
        Course c = new Course();
        model.addAttribute("course", c);
        System.out.println("del cno=" + cno);
        courseMapper.remove(cno);
        return "forward:/adm/course/show";
    }

}
