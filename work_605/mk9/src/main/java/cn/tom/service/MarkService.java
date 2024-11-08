package cn.tom.service;

import cn.tom.entity.Mark;
import cn.tom.entity.MarkInfo;

import java.util.List;

public interface MarkService {
    public List<MarkInfo> findMark(String clzno, String cno);

    public int addMark(Mark mark);
}
