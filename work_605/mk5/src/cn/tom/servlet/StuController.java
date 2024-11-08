package cn.tom.servlet;

import cn.tom.dao.ClzDao;
import cn.tom.dao.UserDao;
import cn.tom.entity.Clz;
import cn.tom.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StuController {
    UserDao userDao = new UserDao();
    ClzDao clzDao = new ClzDao();
    //学生
    public void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String clzno = request.getParameter("clzno");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        List<Map<String, Object>> lst = userDao.findStudents(clzno, phone, name);
        request.setAttribute("stus", lst);
        request.getRequestDispatcher("/WEB-INF/jsp/stu/show.jsp").forward(request, response);
    }

    public void goAdd(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        List<Clz> clzs = clzDao.findAll();
        request.setAttribute("clzs", clzs);
        request.getRequestDispatcher("/WEB-INF/jsp/stu/add.jsp")
                .forward(request, response);
    }

    public void doAdd(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        User t = new User();
        t.setClzno(request.getParameter("clzno"));
        t.setPhone(request.getParameter("phone"));
        t.setPwd(request.getParameter("pwd"));
        t.setUname(request.getParameter("uname"));
        t.setRole(1);
        userDao.add(t);
        request.getRequestDispatcher("/mk5/stu/show.do?clzno=" + t.getClzno())
                .forward(request, response);
    }
    public void goUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        List<Clz> clzs = clzDao.findAll();
        Integer uid= Integer.parseInt(request.getParameter("uid"));
        User t = userDao.findOne(uid, null);
        System.out.println("t=" + t);
        request.setAttribute("stu", t);
        request.setAttribute("clzs", clzs);
        request.getRequestDispatcher("/WEB-INF/jsp/stu/update.jsp")
                .forward(request, response);
    }

    public void doUpdate(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        User t = new User();
        t.setClzno(request.getParameter("clzno"));
        t.setPhone(request.getParameter("phone"));
        t.setPwd(request.getParameter("pwd"));
        t.setUname(request.getParameter("sname"));
        Integer uid= Integer.parseInt(request.getParameter("uid"));
        t.setUid(uid);
        userDao.update(t);
        request.setAttribute("phone", null);
        request.getRequestDispatcher("/mk5/stu/show.do")
                .forward(request, response);
    }
     public void doDel(HttpServletRequest request, HttpServletResponse response)  throws IOException,ServletException{
         Integer uid= Integer.parseInt(request.getParameter("uid"));
        userDao.remove(uid);
        request.getRequestDispatcher("/mk5/stu/show.do")
                .forward(request, response);
    }
}
