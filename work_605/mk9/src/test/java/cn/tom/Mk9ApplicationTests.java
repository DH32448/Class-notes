package cn.tom;

import cn.tom.dao.UserMapper;
import cn.tom.service.MarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mk9ApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.findOneByPhone("135001"));
    }

    @Autowired
    MarkService markService;

}
