package cn.tom.controller;

import cn.tom.entity.Clz;

import java.util.ArrayList;
import java.util.List;

public class ClzController {
    public ClzController() {
        System.out.println("构造ClzController()。。。。");
    }
    public void add() {
        System.out.println("ClzController.add");
    }
    public void update() {
        System.out.println("ClzController.update");
    }

    public List<Clz> findAll() {
        System.out.println("ClzController.findAll");
        return new ArrayList<>();
    }
}
