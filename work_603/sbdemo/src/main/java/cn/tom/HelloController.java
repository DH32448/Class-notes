package cn.tom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @RequestMapping("hi")
    public String hi() {
        return new Date() + " ....";
    }
}
