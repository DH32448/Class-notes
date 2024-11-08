package cn.tom.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MarkServlet extends HttpServlet {
    MarkController markController = new MarkController();  //登分
    ClzController clzController = new ClzController();     //班级
    CourseController courseController = new CourseController(); //课程
    StuController stuController = new StuController();  //学生
    TeaController teaController = new TeaController(); //教师
    TaskController taskController = new TaskController(); //教师班级课程对应表
    LoginController loginController = new LoginController();  //登录
    MyController myController = new MyController();            //我的

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");
        String cmd = request.getServletPath();
        System.out.println("cmd=" + cmd);
        if (cmd.startsWith("/mk5"))  cmd = cmd.substring(4);
        System.out.println("cmd2=" + cmd);
        if ( ! (cmd.startsWith("/main.do") || cmd.startsWith("/login/")) ) {  //除了登录外。， 其他需要登录后才能操作
            HttpSession session = request.getSession();
            Object logined = session.getAttribute("logined");
            if (logined == null) {  //未登录， 转到登录页面
                request.setAttribute("err", "此操作需要登录后才能完成");
                request.getRequestDispatcher("/mk5/main.do").forward(request, response);
                return;
            }
        }
        if ("/main.do".equals(cmd)) doMain(request, response);
        else if ("/clz/show.do".equals(cmd)) clzController.doClzShow( request, response);
        else if ("/clz/add.do".equals(cmd)) clzController.goClzAdd( request, response);  //拼写添加表单  POST 提交方式
        else if ("/clz/doAdd.do".equals(cmd)) clzController.doClzAdd( request, response);  //完成数据接收， 保存
        else if ("/clz/update.do".equals(cmd)) clzController.goClzUpdate( request, response);  //拼写添加表单  POST 提交方式
        else if ("/clz/doUpdate.do".equals(cmd)) clzController.doClzUpdate( request, response);  //完成数据接收， 保存
        else if ("/clz/del.do".equals(cmd)) clzController.doClzDel( request, response);  //完成数据接收， 保存
        else if ("/course/show.do".equals(cmd)) courseController.doCourseShow( request, response);
        else if ("/course/add.do".equals(cmd)) courseController.goCourseAdd( request, response);  //拼写添加表单  POST 提交方式
        else if ("/course/doAdd.do".equals(cmd)) courseController.doCourseAdd( request, response);//完成数据接收， 保存
        else if ("/course/update.do".equals(cmd)) courseController.goCourseUpdate( request, response);  //拼写添加表单  POST 提交方式
        else if ("/course/doUpdate.do".equals(cmd)) courseController.doCourseUpdate(request, response);//完成数据接收， 保存
        else if ("/stu/show.do".equals(cmd)) stuController.doShow( request, response);
        else if ("/stu/add.do".equals(cmd))  stuController.goAdd( request, response);
        else if ("/stu/doAdd.do".equals(cmd)) stuController.doAdd( request, response);
        else if ("/stu/update.do".equals(cmd)) stuController.goUpdate( request, response);
        else if ("/stu/doUpdate.do".equals(cmd)) stuController.doUpdate( request, response);
        else if ("/stu/del.do".equals(cmd))  stuController.doDel( request, response);
        else if ("/tea/show.do".equals(cmd)) teaController.doShow( request, response);
        else if ("/tea/add.do".equals(cmd))  teaController.goAdd( request, response);
        else if ("/tea/doAdd.do".equals(cmd)) teaController.doAdd( request, response);
        else if ("/tea/update.do".equals(cmd)) teaController.goUpdate( request, response);
        else if ("/tea/doUpdate.do".equals(cmd)) teaController.doUpdate( request, response);
        else if ("/mark/main.do".equals(cmd)) markController.doMain( request, response);
        else if ("/mark/show.do".equals(cmd)) markController.doShow( request, response);
        else if ("/mark/doAdd.do".equals(cmd)) markController.doAdd( request, response);
        else if ("/mark/doFind.do".equals(cmd)) markController.doFind( request, response);
        else if ("/login/doLogin.do".equals(cmd)) loginController.doLogin( request, response);
        else if ("/login/logout.do".equals(cmd)) loginController.doLogout( request, response);
        else if ("/my/go2UpdateMe.do".equals(cmd)) myController.go2UpdateMe( request, response);
        else if ("/my/doUpdateMe.do".equals(cmd)) myController.doUpdateMe( request, response);
        else {
            response.getWriter().println("<h2> 正在建设中:" + cmd + "</h3>");
            response.flushBuffer();
        }
    }

    private void doMain(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
