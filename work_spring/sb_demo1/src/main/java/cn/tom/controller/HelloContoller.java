package cn.tom.controller;

import cn.tom.dao.ClzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloContoller {
    //如何证明 HelloContoller  被  new

    //ClzDao clzDao = new ClzDao();  这段代码成为历史

    //从 ioc.getBean(ClzDao.class) 获取到 clzDao
    // Auto  自动 wire 绑定
    @Autowired
    private ClzDao clzDao;
    // private ClzDao clzDao = ioc.getBean(ClzDao.class);

    public HelloContoller() {
        System.out.println("HelloContoller  被  new。。。");
    }

    @RequestMapping("/hi")
    public String doHi(HttpServletResponse response) throws Exception {
        System.out.println("clzDao=" + clzDao);
        clzDao.add();
        return "hi";
    }
}
