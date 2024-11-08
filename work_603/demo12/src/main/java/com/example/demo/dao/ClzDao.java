package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component//id默认值就是类名称，第一个改小写
    public class ClzDao {
        public ClzDao() {
            System.out.println("ClzDao对象");
        }
        public void add(){
            System.out.println("添加一个用户");
        }

}
