package cn.tom.controller.adm;

import cn.tom.dao.ClzMapper;
import cn.tom.entity.Clz;
import cn.tom.service.ClzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
       DispatcherServlet  SpringMVC  框架 提供通用 HttpServlet



        String action = req.getServletPath();
        System.out.println("GET请求动作 action:" + action);
        //把 变量  put req.map
        req.setAttribute("action", action);
        if ("/show.do".equals(action))  { doShow(req, resp); return;}
        if ("/showdog.do".equals(action))  { doShowDog(req, resp); return;}

 */


//班级管理
@Controller
@RequestMapping("/adm/clz")
public class AdmClzController {
    @Autowired(required = false)
    ClzService clzService;
    //添加页面
    @RequestMapping("/go2Add")    //adm/clz/go2Add
    public String  go2Add(Model model) {
        //1 拿 session, 是不是登录
        //2 . role  == adm
        model.addAttribute("action",
                "Add");
        // 注意： 无参数构造方法， 重写一下， 设置初始值 clzno="", clzname=""
        Clz  clz = new Clz();
        model.addAttribute("clz", clz);
        return "forward:/adm/clz/show";
    }
    //获取添加数据， 并写到数据库
    @RequestMapping("/doAdd")    //adm/clz/doAdd
    public String  doAdd(Clz clz) {
        //1 拿 session, 是不是登录
        //2 . role  == adm

        //添加到数据库， 转发到班级页面
        System.out.println("Add Clz=" + clz);
        clzService.add(clz);
        return "forward:/adm/clz/show";
    }
    //列表
    @RequestMapping("/show")    //adm/clz/show
    public String  doShow(Model model) {
        //1 拿 session, 是不是登录
        //2 . role  == adm

        //获取班级数据， 显示页面
        List<Clz> lst = clzService.findAll();
        System.out.println("show clzs=" + lst);
        model.addAttribute("clzs", lst);
        return "adm/clz/show";
    }

    //获取修改页面
    @RequestMapping("/go2Update")    //adm/clz/go2Update
    public String  go2Update(Model model,String clzno) {
        //根据主键获取修改记录, 并页面表单上
        System.out.println("update clzno=" + clzno);
        model.addAttribute("action",
                "Update");
        Clz clz = clzService.findOne(clzno);
        model.addAttribute("clz", clz);
        System.out.println("update clz=" + clz);
        return "forward:/adm/clz/show";
    }
    //获取更新数据， 并写到数据库
    @RequestMapping("/doUpdate")    //adm/clz/doUpdate
    public String  doUpdate(Clz clz) {
        //更新数据库数， 转发到班级页面
        System.out.println("u[pdate Clz=" + clz);
        clzService.update(clz);
        return "forward:/adm/clz/show";
    }

    //删除
    @RequestMapping("/del")    //adm/clz/del
    public String  doDel(String clzno, Model model) {
        //更新数据库数， 转发到班级页面
        System.out.println("del clzno=" + clzno);
        clzService.remove(clzno);
        Clz  clz = new Clz();
        model.addAttribute("clz", clz);
        return "forward:/adm/clz/show";
    }

}
