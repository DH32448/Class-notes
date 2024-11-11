package cn.tom.anno;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1. 加保留期  - 运行期间  RUNTIME
@Retention(RetentionPolicy.RUNTIME)

//2. 哪个位置  TYPE(类）  METHOD(方法上)   成员变量   参数变量

/**
@Service("clzService")
    @Service(value="clzService")   value 可以省略
@Resource(name="clzService")
 **/

// @Table("t_ke")    value 可以省略
// @Table(value = "t_ke")
@Target(ElementType.TYPE)
public @interface Table {
    //字符串           默认值
    String    value() default "";

}
