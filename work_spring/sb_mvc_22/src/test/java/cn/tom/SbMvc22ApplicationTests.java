package cn.tom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SbMvc22ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUUID() {
        for(int i=0; i<10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println("uuid=" + uuid);
            uuid = uuid.replace("-", "");  //去掉 -
            System.out.println("uuid=" + uuid );
        }
    }
}
