//package com.xian.requireproject.controller.common;
//
//import com.xian.requireproject.common.remind.JsonResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.UUID;
//
///**
// * @Description 文件上传
// * @Author zw
// * @Date 2021/1/14 12:12
// */
//@Api(value = "sysUser",tags = {"文件上传"})
//@Controller("/uploadFile")
//@CrossOrigin
//public class UploadController {
//    //文件上传位置
//    @Value("${file.upload.path}")
//    private String filePath;
//
//    @RequestMapping("/upload")
//    @ApiOperation(value = "文件上传",notes = "文件上传",httpMethod = "POST",response = String.class)
//    public JsonResult upload(MultipartFile attach){
//        //判断文件是否为空，不为空则进行文件上传
//        if(!attach.isEmpty()){
//            //获取源文件名称
//            String fileName = attach.getOriginalFilename();
//            //获取源文件后缀名
//            String suffix = FilenameUtils.getExtension(fileName);
//            //使用UUID重命名文件名称
//            String newFileName= UUID.randomUUID().toString().replace("-","").toUpperCase()+"."+suffix;
//            //使用日期解决同一文件夹中文件过多问题（以当前日期命名文件夹）
//            String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//            //组装最终文件名
//            String finalName = datePath +"/" + newFileName;
//            //构建文件对象
//            File dest = new File(filePath +finalName);
//            //判断该文件夹是否存在，不存在则创建
//            if (!dest.getParentFile().exists()) {
//                dest.getParentFile().mkdirs();//创建文件夹
//            }
//            try {
//                //将文件保存到硬盘
//                attach.transferTo(dest);
//                //将当前图片放到模型中，便于页面回显
//                return JsonResult.success("OK");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //返回页面（该页面是templates目录下的页面）
//        return JsonResult.success("文件上传失败!");
//    }
//}
