package cn.tom;

import cn.tom.dao.ClzDao;
import cn.tom.entity.Clz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mark31ApplicationTests {
    @Autowired
    ClzDao clzDao;

    @Test
    public void testClz() {
        System.out.println("单元测试");
        List<Clz> all = clzDao.findAll();
        System.out.println(all);
    }
}
