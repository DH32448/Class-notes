package cn.tom.controller;

import cn.tom.cn.tom.dao.CourseDao;
import cn.tom.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MarkServlet extends HttpServlet {

    CourseDao courseDao = new CourseDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");
        String cmd = request.getServletPath();
        System.out.println("cmd=" + cmd);

        if ("/course/show.do".equals(cmd)) go2ShowCourse( request, response);  //显示全部
        if ("/course/add.do".equals(cmd)) go2AddCourse( request, response);  //添加表单  POST 提交方式
        else if ("/course/doAdd.do".equals(cmd)) addCourse( request, response);//完成添加数据接收， 保存
        else if ("/course/update.do".equals(cmd)) go2UpdateCourse( request, response);//获取修改表单
        else if ("/course/doUpdate.do".equals(cmd)) updateCourse( request, response);//完成修改数据接收， 保存
        else if ("/course/del.do".equals(cmd)) delCourse( request, response);//完成删除
        else {
            response.getWriter().println("<h2> 正在建设中:" + cmd + "</h3>");
            response.flushBuffer();
        }
    }


    //获取添加的 表单， 用 POST  提交方式
    private void go2AddCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/course/add.jsp").forward(request,response);
    }
    //获取添加表单数据，用 POST  提交方式， 并调用 dao 保存到数据库
    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course c = new Course();
        c.setCno(request.getParameter("cno"));
        c.setCname(request.getParameter("cname"));
        c.setTid(request.getParameter("tid"));
        courseDao.add(c);
        request.setAttribute("msg", "添加成功:" + c.getCname()+ "， 并返回列表");
        request.getRequestDispatcher("/course/show.do").forward(request,response);
    }

    //获取修改的 表单及被修改的对象， 用 POST  提交方式
    private void go2UpdateCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course c = courseDao.findById(request.getParameter("cno"));
        request.setAttribute("c", c );
        request.getRequestDispatcher("/WEB-INF/jsp/course/update.jsp").forward(request,response);
    }
    //获取修改表单的数据，用 POST  提交方式， 并调用 dao 保存到数据库
    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String err = "";
        Course c = new Course();
        c.setCno(request.getParameter("cno"));
        c.setCname(request.getParameter("cname"));
        c.setTid(request.getParameter("tid"));
        courseDao.update(c);
        request.setAttribute("msg", "修改成功:" + c.getCname()+ "， 并返回列表");
        request.getRequestDispatcher("/course/show.do").forward(request,response);
    }
    //根据主键删除
    private void delCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        courseDao.removeByID(request.getParameter("cno"));
        request.setAttribute("msg", "删除成功:" + request.getParameter("cno")+ "， 并返回列表");
        request.getRequestDispatcher("/course/show.do").forward(request,response);
    }
    //显示所有的课程
    private void  go2ShowCourse(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        List<Course> cs = courseDao.findAll();
        request.setAttribute("cs", cs);
        request.getRequestDispatcher("/WEB-INF/jsp/course/show.jsp").forward(request,response);
    }
}
