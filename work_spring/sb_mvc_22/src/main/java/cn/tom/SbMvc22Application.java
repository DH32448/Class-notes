package cn.tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("cn.tom.filter")
@SpringBootApplication
public class SbMvc22Application {

    public static void main(String[] args) {
        SpringApplication.run(SbMvc22Application.class, args);
    }

}
