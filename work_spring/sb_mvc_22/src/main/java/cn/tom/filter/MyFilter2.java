package cn.tom.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter2", urlPatterns = "/*")
public class MyFilter2 implements Filter {
    public MyFilter2() {
        System.out.println("MyFilter2() .....");
    }
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到过滤器2....");
        //1. session
        //2. 请求路径

        //ServletRequest 向下转型 HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object teacher = session.getAttribute("teacher");

        String servletPath = req.getServletPath();

        System.out.println("session.teacher=" + teacher);
        System.out.println("请求路径2:" + servletPath);

        //调用下一个过滤器， 让过滤器继续过滤， 直到 Servet(Countroler)
        filterChain.doFilter(servletRequest,servletResponse);
        // 交给下一步， 往下走

    }
}
