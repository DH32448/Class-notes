package cn.tom.servlet;

import cn.tom.dao.ClzDao;
import cn.tom.dao.CourseDao;
import cn.tom.dao.MarkDao;
import cn.tom.dao.UserDao;
import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.Mark;
import cn.tom.entity.MarkInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class MarkController {
    ClzDao clzDao = new ClzDao();
    CourseDao courseDao = new CourseDao();
    UserDao stuDao = new UserDao();
    MarkDao markDao = new MarkDao();

    public void doMain(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        List<Clz> clzs = clzDao.findAll();
        List<Course> cs = courseDao.findAll();
        request.setAttribute("clzs", clzs);
        request.setAttribute("cs", cs);
        request.getRequestDispatcher("/WEB-INF/jsp/mark/main.jsp")
                .forward(request, response);
    }
    public void doFind(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        // mks
        // clz
        // c
        List<MarkInfo> mks = new ArrayList<>();
        String clzno = request.getParameter("clzno");
        String cno = request.getParameter("cno");
        System.out.println("doFind clzno=" + clzno);
        System.out.println("doFind cno=" + cno);
        Clz clz = clzDao.findByClzno(clzno);
        Course cour = courseDao.findByCno(cno);

        // 查找该班级学生
        List<Map<String, Object>> stus = stuDao.findStudents(clzno, null, null);
        // 查找该班级已录入对应 sno, cno 的分数
        // 拼接
        for(Map<String, Object> s : stus) {
            MarkInfo mk = new MarkInfo();
            mk.setClzno(clzno); mk.setClzname(clz.getClzname());
            mk.setCno(cno);  mk.setCname(cour.getCname());
            mk.setSno((String)s.get("sno"));
            mk.setSname((String) s.get("sname"));
            Mark k = markDao.findOne(mk.getSno(), cno);
            mk.setId(0);
            mk.setScore(0);
            if (k!=null) {
                mk.setScore(k.getScore());
                mk.setId(k.getId());
            }
            mks.add(mk);
        }
        request.setAttribute("clz", clz);
        request.setAttribute("cour", cour);
        request.setAttribute("mks", mks);
        request.getRequestDispatcher("/WEB-INF/jsp/mark/add.jsp")
                .forward(request, response);
    }

    public void doAdd(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        String clzno = request.getParameter("clzno");
        System.out.println("doAdd clzno=" + clzno);
        String cno = request.getParameter("cno");
        String strId = request.getParameter("id");
        String strScore = request.getParameter("score");
        String sno = request.getParameter("sno");
        int id = Integer.parseInt(strId);
        double score = Double.parseDouble(strScore);
        Date tpost = new Date();
        if (id!=0) {   // id  ！=0， 表示已有记录， 更新即可
            markDao.update(id, score);
        } else {
            markDao.add(sno, cno, score, tpost);
        }
        request.getRequestDispatcher("/mk5/mark/doFind.do?clzno=" + clzno + "&cno=" + cno)
                .forward(request, response);
    }

    public void doShow(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        //左连接查询
        List<MarkInfo> mks = markDao.findInfo();
        request.setAttribute("mks", mks);
        request.getRequestDispatcher("/WEB-INF/jsp/mark/show.jsp")
                .forward(request, response);
    }


}
