package cn.tom.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MarkServlet extends HttpServlet {
    public MarkServlet() {
        System.out.println("MarkServlet().....");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //业务代码写这里
       String action = req.getServletPath();
       System.out.println("action=" + action);
       if ("/course/del.do".equals(action)) {
           //获取 CID
           String cid = req.getParameter("cid");
           String score = req.getParameter("score");
           resp.getWriter().println(action);
           resp.getWriter().println("cid=" + cid);
           resp.getWriter().println("score=" + score);
       }
        resp.getWriter().println(action);

    }
}
