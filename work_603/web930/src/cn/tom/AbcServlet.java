package cn.tom;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbcServlet extends HttpServlet {
    public AbcServlet() {
        System.out.println("AbcServlet() .....");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求动作  <a  href='请求动作' />
        //2. 获取请求动作  <form method='GET' action='请求动作' >
        String action = req.getServletPath();
        System.out.println("GET请求动作 action:" + action);
        //把 变量  put req.map
        req.setAttribute("action", action);
        if ("/show.do".equals(action))  { doShow(req, resp); return;}
        if ("/showdog.do".equals(action))  { doShowDog(req, resp); return;}

        //把请求 转发 到 hello.jsp
        req.getRequestDispatcher("/hello.jsp").forward(req,resp);
    }

    public void doShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<10; i++) lst.add(i+100);
        req.setAttribute("lst", lst);
        req.getRequestDispatcher("/show.jsp").forward(req, resp);
    }

    public void doShowDog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dog> lst = new ArrayList<>();
        for(int i=0; i<10; i++) lst.add(
                new Dog(i+1, i*100+1.1));
        req.setAttribute("dogs", lst);
        req.getRequestDispatcher("/show_dog.jsp").
                forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2. 获取请求动作  <form method='POST' action='请求动作' >
        String action = req.getServletPath();
        System.out.println("POST 请求动作 action:" + action);
        //把 变量  put req.map
        req.setAttribute("action", action);
        //把请求 转发 到 hello.jsp
        req.getRequestDispatcher("/hello.jsp").forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init() ....， 初始化， 只执行一次（创建 Servlet 对象后立即执行）");
        System.out.println("比如读取文件放在这里");
    }
}
