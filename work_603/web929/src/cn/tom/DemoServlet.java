package cn.tom;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;   //HttpServlet 是 Tomcat 的 sevlet-api.jar
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//这个每次请求都会创建 DemoServlet 对象
public class DemoServlet extends HttpServlet {
    public DemoServlet() {
        System.out.println("DemoServlet() 无参数构造方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init() config=" + config);
    }

    // doGet   对应就是  <a>  地址栏请求
    //  GET /move?num=100 HTTP/1.1
    @Override
    protected void doGet(HttpServletRequest req, //请求
                         HttpServletResponse resp //响应
            )
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //1. /move 在哪里
        String action = req.getServletPath();  //  /move  请求动作
        System.out.println("action: 请求动作=" + action);
        //2. 取参数
        String num = req.getParameter("pagenum"); //HTTP  协议就是字符串协议
        System.out.println("num:" + num);

        String pageline = req.getParameter("pageline"); //HTTP  协议就是字符串协议
        System.out.println("pageline:" + pageline);

        //*.do  请求 , 通过代码再发出一次请求 *.jsp（没有通过浏览器）
        //Java 对象 调用  JSP  的对象， 服务器内部 跳转
        //req 对象 有个 Map<String, Object> , 作为传值使用
        List<Integer> lst = new ArrayList<>();
        lst.add(100); lst.add(101); lst.add(102);
        req.setAttribute("lst", lst); // req.map.put("lst", lst);
        req.setAttribute("act", action);   //map.put
        req.setAttribute("birth",  new Date());  //map.put
        //                   key    对象（Object）
        // Request 请求  Dispatcher 转发器
        req.getRequestDispatcher("/a.jsp").forward(req, resp);

    }
}
