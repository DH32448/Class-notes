package cn.tom.controller;

import cn.tom.dao.LargeFileDao;
import cn.tom.dao.StuDao;
import cn.tom.entity.LargeFile;
import cn.tom.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired(required = false)
    LargeFileDao largeFileDao;

    @Autowired
    StuDao stuDao;

    //获取上传文件的表单
    @GetMapping("/go2upload")
    public String go2Upload() {
        return "upload";
    }

    /*
     <form  action="/file/upload" method="post" enctype="multipart/form-data">
       请选择图片:<input name="img" type="file" />
     */

    @PostMapping("/upload")
    public String upload(MultipartFile img) throws IOException {
        System.out.println("largeFileDao=" + largeFileDao);
        if (img == null) {
            System.out.println("没有文件上传");
        }
        System.out.println("文件大小：" + img.getSize()); // 文件多少个字节

        System.out.println("文件名：" + img.getOriginalFilename());

        //1. 保存文件范式
//        File file = new File("D:/new_" + img.getOriginalFilename());
//        img.transferTo(file);  //File 对象

        //2. 保存到数据库
        LargeFile largeFile = new LargeFile();
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid=" + uuid);
        largeFile.setId(uuid);
        largeFile.setFilename(img.getOriginalFilename());
        byte[] buf = img.getBytes();
        System.out.println("buf.length=" + buf.length);
        largeFile.setContent( buf );   //文件内容 bye[] ---->  Object content
        largeFileDao.add(largeFile);

        return "ok";
    }

    /**
     *     private String sno;     //sno  ---> imgid
     *     private String sname;
     *     private String phone;
     *     private String imgid;   //uuid  作为 LargeFile.id 外键
     *     imgid 别和 图片变量 file 相同
     */
    @GetMapping("/go2add")   //获取添加的  form
    public String go2Add() {
        return "add";
    }

    /*
         @RequestParam  参数注解
         <input name  和 接收变量名不一致时， 做个转换处理
          required = true, 页面必须有输入， 默认值 false
          @Param    MyBatis 多个参数
          @PathVariable   路径参数
     */
    @PostMapping("/add")   // file/add
    public String add(Stu stu,
                      @RequestParam(value = "img",
                       required = true) MultipartFile filex) {
        System.out.println("stu=" + stu);
        System.out.println("filex=" +filex);

        //没有图片的情形你就结束了
        if (filex == null || filex.isEmpty() == true) {
            System.out.println("没有图片");
            // 直接保存学生
            stuDao.add(stu);
            return "ok";
        }
        //有图片的情形, 保持图片和学生
        //2. 保存到数据库
        String uuid = UUID.randomUUID().toString();
        try {
            LargeFile largeFile = new LargeFile();
            System.out.println("uuid=" + uuid);
            largeFile.setId(uuid);
            largeFile.setFilename(filex.getOriginalFilename());
            byte[] buf = filex.getBytes();
            System.out.println("buf.length=" + buf.length);
            largeFile.setContent(buf);   //文件内容 bye[] ---->  Object content
            largeFileDao.add(largeFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "err";
        }
        //图片保存成功
        // 学生和图片要关联起来，uuid 是 t_largefile 的主键， uuid 作为学生外键
        stu.setImgid( uuid );   // ******  这一行理解清楚
        stuDao.add( stu);
        return "ok";
    }



    @GetMapping("/showimg/{uuid}")
    public void showImg(@PathVariable("uuid")
                                    String id,
                         HttpServletResponse resp
    ) throws IOException {
        System.out.println("id=" + id);
        LargeFile one = largeFileDao.findOne(id);
        Object content = one.getContent();

        OutputStream os = resp.getOutputStream();
        resp.setContentType("image/jpeg");
        //byte[] buf = new byte[1024];
        byte[] buf = (byte[])content;
        os.write(buf);
        os.flush();
    }
}

