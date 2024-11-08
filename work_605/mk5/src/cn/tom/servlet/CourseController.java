package cn.tom.servlet;

import cn.tom.dao.CourseDao;
import cn.tom.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CourseController {
    CourseDao courseDao = new CourseDao();
    //课程
    public void doCourseShow(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        List<Map<String,Object>> lst = courseDao.findInfo();
        request.setAttribute("cs", lst);
        request.getRequestDispatcher("/WEB-INF/jsp/course/show.jsp")
                .forward(request, response);
    }

    public void goCourseAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/course/add.jsp")
                .forward(request, response);
    }

    public void doCourseAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course c = new Course();
        c.setCno(request.getParameter("cno"));
        c.setCname(request.getParameter("cname"));
        courseDao.add(c);
        request.getRequestDispatcher("/mk5/course/show.do")
                .forward(request, response);
    }

    public void goCourseUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course c = courseDao.findByCno(request.getParameter("cno"));
        request.setAttribute("c", c);
        request.getRequestDispatcher("/WEB-INF/jsp/course/update.jsp")
                .forward(request, response);
    }

    public void doCourseUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course c = new Course();
        c.setCno(request.getParameter("cno"));
        c.setCname(request.getParameter("cname"));
        courseDao.update(c);
        request.getRequestDispatcher("/mk5/course/show.do")
                .forward(request, response);
    }
}
