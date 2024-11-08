package cn.tom.controller;

//不管那一层的异常， 统一由这个控制器处理

//统一异常处理

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

//advice 通知
@ControllerAdvice
public class ErrController {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String doIntegrityException(Exception e, Model model) {
        model.addAttribute("msg", "主键编码重复");
        return "err";
    }

    @ExceptionHandler(SQLException.class)
    public String doSQL(Exception e, Model model) {
        model.addAttribute("msg",  e.getMessage());
        return "err";
    }

    @ExceptionHandler(IOException.class)
    public String doIOException(Exception e, Model model) {
        model.addAttribute("msg",  "网络故障..." + e.getMessage());
        return "err";
    }

    @ExceptionHandler(Exception.class)
    public String doException(Exception e, Model model) {
        model.addAttribute("msg",    e.getMessage());
        return "err";
    }

}
