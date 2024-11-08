package cn.tom.servlet;

import cn.tom.dao.UserDao;
import cn.tom.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TeaController {
    //教师
    UserDao userDao = new  UserDao();
    public void goAdd(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/tea/add.jsp")
                .forward(request, response);
    }

    public void doAdd(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        request.getRequestDispatcher("/mk5/tea/show.do")
                .forward(request, response);
    }
    public void goUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/tea/update.jsp")
                .forward(request, response);
    }

    public void doUpdate(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
        request.getRequestDispatcher("/mk5/tea/show.do")
                .forward(request, response);
    }


    public void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> lst = userDao.findAll(null, 9);
        request.setAttribute("teas", lst);
        request.getRequestDispatcher("/WEB-INF/jsp/tea/show.jsp")
                .forward(request, response);
    }
}
