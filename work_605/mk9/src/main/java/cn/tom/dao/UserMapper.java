package cn.tom.dao;

import cn.tom.entity.Course;
import cn.tom.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //User 类里面加了一个属性: clzname
    public User findOneByPhone(String phone);  //登录使用
    //如下 2 个查询都用 左连接完成， 这样就适应教师和学生的要求
    public List<User> findByRole(int role);  //根据角色找  学生=1， 教师 =5
    public List<User> findStusByclz(String clzno);  //查找某个班级的所有学生
    public User  findByUid(int uid);

    public int add(User user);   //角色 及班级编号在 教师和学生控制器中完成
    public int update(User  user); //角色 及班级编号在 教师和学生控制器中完成
    public int updatePwd(User  user);
    public int remove(int uid);
}
