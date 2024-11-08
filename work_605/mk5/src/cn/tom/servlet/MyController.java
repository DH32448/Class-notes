package cn.tom.servlet;

import cn.tom.dao.ClzDao;
import cn.tom.dao.UserDao;
import cn.tom.entity.Clz;
import cn.tom.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyController {
    UserDao userDao = new UserDao();
    ClzDao clzDao = new ClzDao();

    public void go2UpdateMe(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("logined");
        if (u == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/unlogin.jsp")
                    .forward(request, response);
            return;
        }
        System.out.println("uid=" + u.getUid());
        User user = userDao.findOne(u.getUid(), null);
        request.setAttribute("u", user);
        if (u.getRole()==1) {
            Clz c = clzDao.findOne(u.getClzno());
            request.setAttribute("clz", c);
            request.getRequestDispatcher("/WEB-INF/jsp/my/updateStu.jsp")
                    .forward(request, response);
            return;
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/my/updateTea.jsp")
                    .forward(request, response);
            return;
        }
    }
    public void doUpdateMe(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("logined");
        if (u == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/unlogin.jsp")
                    .forward(request, response);
            return;
        }
        String phone = request.getParameter("phone");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if (phone!=null && phone.length()>1)  u.setPhone(phone);
        if (uname!=null && uname.length()>1)  u.setUname(uname);
        if (pwd!=null && pwd.length()>1) u.setPwd(pwd);
        userDao.update(u);
        request.getRequestDispatcher("/WEB-INF/jsp/ok.jsp")
                .forward(request, response);
    }
}
