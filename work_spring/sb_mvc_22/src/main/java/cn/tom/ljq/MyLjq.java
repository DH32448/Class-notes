package cn.tom.ljq;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyLjq implements HandlerInterceptor {
    public MyLjq() {
        System.out.println("构造方法....拦截器....");
    }
    //Alt insert

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("拦截器....");
        System.out.println("请求路径:" + request.getServletPath());
        System.out.println("session" + request.getSession().getAttribute("teacher"));
        System.out.println("============================================================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
