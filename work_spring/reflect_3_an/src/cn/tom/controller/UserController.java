package cn.tom.controller;

import cn.tom.anno.ReqMapping;

/**
 * public @interface ReqMapping {
 *     String value() default "";
 *     String method() defualt "";
 * }
 */

@ReqMapping("/adm/usr/")
public class UserController {
    public UserController() {
        System.out.println("构造UserController()。。。。");
    }
    @ReqMapping("/add.do")
    public void add() {
        System.out.println("UserController.add");
    }
    @ReqMapping("/update.do")
    public void update() {
        System.out.println("UserController.update");
    }
}
