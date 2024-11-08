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
import java.util.List;

public class LoginController {
    UserDao userDao = new UserDao();
    ClzDao clzDao = new ClzDao();
    public void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("err", "");
        request.getRequestDispatcher("/mk5/main.do")
                .forward(request, response);
    }
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        String  phone= request.getParameter("phone");
        String pwd =  request.getParameter("pwd");
        User t = userDao.findOne(null, phone);
        System.out.println("t=" + t);
        if (t== null) {
            request.setAttribute("err", "登录失败-账号有误");
            request.getRequestDispatcher("/mk5/main.do")
                    .forward(request, response);
            return;
        }
        if (pwd==null ) {
            request.setAttribute("err", "登录失败-密码不能为空");
            request.getRequestDispatcher("/mk5/main.do")
                    .forward(request, response);
            return;
        }
        if (pwd.equals(t.getPwd()) ) {
            HttpSession session = request.getSession();
            session.setAttribute("logined", t);
            request.setAttribute("err", "登录成功！！！！");
            request.getRequestDispatcher("/mk5/main.do")
                    .forward(request, response);
            return;
        } else {
            request.setAttribute("err", "登录失败-密码匹配失败");
            request.getRequestDispatcher("/mk5/main.do")
                    .forward(request, response);
            return;
        }
    }


}
