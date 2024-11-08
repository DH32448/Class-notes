package cn.tom.servlet;

import cn.tom.dao.ClzDao;
import cn.tom.entity.Clz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClzController {
    //班级
    ClzDao clzDao = new ClzDao();
    public void goClzAdd(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/clz/add.jsp")
                .forward(request, response);
    }

    public void doClzAdd(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        Clz c = new Clz();
        c.setClzno(request.getParameter("clzno"));
        c.setClzname(request.getParameter("clzname"));
        clzDao.add(c);
        request.getRequestDispatcher("/mk5/clz/show.do")
                .forward(request, response);
    }
    public void goClzUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        Clz c = clzDao.findByClzno(request.getParameter("clzno"));
        request.setAttribute("c", c);
        request.getRequestDispatcher("/WEB-INF/jsp/clz/update.jsp")
                .forward(request, response);
    }

    public void doClzUpdate(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        Clz c = new Clz();
        c.setClzno(request.getParameter("clzno"));
        c.setClzname(request.getParameter("clzname"));
        clzDao.update(c);
        request.getRequestDispatcher("/mk5/clz/show.do")
                .forward(request, response);
    }

    public void doClzDel(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        String clzno = request.getParameter("clzno");
        clzDao.remove(clzno);
        request.getRequestDispatcher("/mk5/clz/show.do")
                .forward(request, response);
    }


    public void doClzShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Clz> lst = clzDao.findAll();
        request.setAttribute("clzs", lst);
        request.getRequestDispatcher("/WEB-INF/jsp/clz/show.jsp")
                .forward(request, response);
    }

}
