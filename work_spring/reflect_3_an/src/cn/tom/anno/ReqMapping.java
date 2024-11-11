package cn.tom.anno;
//@RequestMapping

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@RequestMapping(value = "/go2Add",method = RequestMethod.GET)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ReqMapping {
    String value() default "";
    String method() default "";
}
