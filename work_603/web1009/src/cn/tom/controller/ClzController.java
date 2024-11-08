package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller   //我是控制器和前端打交道， 会自动创建对象
@RequestMapping("/clz")
public class ClzController {

    //第一步， 获取更新的表单， 指定更新哪一条（主键  手机 身份证 订单号）
    @RequestMapping("/go2Update.do")   // clz/add.do
    public String go2Update(String cno, HttpServletRequest req) {
        //无需绑定对象， 绑定主键  或 手机号 。。。。
        //根据主键去查找该条记录

        Clz  c = clzDao.findByCno( cno );
        if (c  == null)  c = new Clz();
        // 这里创建空对象给到前端， 前端就可以避免 500
        // <input  value = "${c.cno}

        req.setAttribute("clz", c);
        return "clz/update";
    }

    //第二步， 获取表单的数据， 根据主键做更新操作
    @RequestMapping("/update.do")   // clz/add.do
    public String go2Update(Clz  clz, HttpServletRequest req) {
        System.out.println("clz=" + clz);
        clzDao.update(c);
        req.setAttribute("msg", "更新成功");
        return "forward: /clz/show.do";
    }



    //第一步， 获取更新的表单， 指定更新哪一条（主键  手机 身份证 订单号）
    @RequestMapping("/go2UpdateByPhone.do")   // clz/add.do
    public String go2Add(String phone, HttpServletRequest req) {
        //无需绑定对象， 绑定主键  或 手机号 。。。。
        return "clz/add";
    }

    //第一步， 获取添加的表单
    @RequestMapping("/go2Add.do")   // clz/add.do
    public String go2Add(HttpServletRequest req) {
        return "clz/add";
    }

    //第二步， 获取表单数据， 保存到数据库
    @RequestMapping("/add.do")   // clz/add.do
    public String add(Clz  c, HttpServletRequest req) {
        System.out.println("clz=" + c);
        clzDao.add(c);

        req.setAttribute("msg", "添加成功");

        return "forward:/clz/show.do";  //转发
        // request.getRequestDispacther("/course/show.do").
    }
}
