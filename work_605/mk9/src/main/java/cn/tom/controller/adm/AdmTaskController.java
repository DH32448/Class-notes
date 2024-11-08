package cn.tom.controller.adm;

import cn.tom.dao.ClzMapper;
import cn.tom.dao.CourseMapper;
import cn.tom.dao.TaskMapper;
import cn.tom.dao.UserMapper;
import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.TaskInfo;
import cn.tom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adm/task")
public class AdmTaskController {
    @Autowired
    ClzMapper clzMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TaskMapper taskMapper;

    @RequestMapping("/show")
    public String show(Model model) {
        List<User> teachers = userMapper.findByRole(5); //获取教师的数据
        List<Clz> clzs = clzMapper.findAll();
        List<Course> courses = courseMapper.findAll();
        List<TaskInfo> tasks = taskMapper.findAll();

        model.addAttribute("teachers",teachers);
        model.addAttribute("clzs",clzs);
        model.addAttribute("courses",courses);
        model.addAttribute("tasks",tasks);

        return "adm/task/show"; ///adm/task/show.html
    }
    ///adm/task/del?kid=' + ${t.kid}

    @RequestMapping("/del")
    public String doDel(int kid) {
        System.out.println("task del kid=" + kid);
        taskMapper.remove(kid);
        return "forward:/adm/task/show";
    }

    ///adm/task/doAdd
    @RequestMapping("/doAdd")
    public String doAdd(TaskInfo taskInfo) {
        System.out.println("task add=" + taskInfo);
        try {
            taskMapper.add(taskInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "forward:/adm/task/show";
    }
}
