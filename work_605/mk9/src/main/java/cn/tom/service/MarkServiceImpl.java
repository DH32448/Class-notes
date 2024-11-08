package cn.tom.service;

import cn.tom.dao.CourseMapper;
import cn.tom.dao.UserMapper;
import cn.tom.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkServiceImpl implements MarkService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<MarkInfo> findMark(String clzno, String cno) {
        //注意 List  某个班级某门课程的成绩单
        List<MarkInfo> mks = new ArrayList<>();
        // 查找该班级所有学生
        List<User> stus = userMapper.findStusByclz(clzno);
        // 查找该班级已录入对应 sno, cno 的分数
        // 拼接
        for(User s : stus) {
            MarkInfo mk = new MarkInfo();
            mk.setClzno(clzno); mk.setClzname(clz.getClzname());
            mk.setCno(cno);  mk.setCname(cour.getCname());
            mk.setSno(s.getPhone());
            mk.setSname(s.getUname());
            // 先假设， 这个学生这门课程没有成绩
            mk.setId(0);
            mk.setScore(0);

            Map<String, Object> map = new HashMap<>();
            map.put("sno" , s.getPhone()); //t_mark.sno  = t_user.phone
            map.put("cno", cno);
            // 而后到 t_mark 查找这个学生这门课程没有成绩
            Mark k = markMapper.findBySnoCno(map);
            // t_mark 有这位学生的成绩
            if (k!=null) {
                mk.setScore(k.getScore());
                mk.setId(k.getId());
            }
            mks.add(mk);
        }
        return mks;
    }

    @Override
    public int addMark(Mark mark) {
        return 0;
    }
}
