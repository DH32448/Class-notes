package cn.tom.service;

import cn.tom.entity.Clz;

import java.util.List;

public interface ClzService {
    public List<Clz> findAll();
    public int add(Clz clz);
    public int update(Clz  clz);
    public int remove(String clzno);
    public Clz findOne(String clzno);
}
