package cn.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @RequestMapping("/hi")
    public void doHi(HttpServletResponse resp) throws Exception {
        resp.getWriter().write("<h2>Hello </h2>");
        resp.flushBuffer();
    }
}
