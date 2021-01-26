package com.xian.requireproject.controller.common;//package com.xian.requireproject.controller.common;
//
//import org.apache.commons.io.IOUtils;
//import org.jodconverter.core.DocumentConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
///**
// * @Description TODO
// * @Author zw
// * @Date 2021/1/13 15:53
// */
//
//@Controller("previewFile")
//public class PreviewController {
//    @Autowired
//    private DocumentConverter converter; // 转换器
//    @Autowired
//    private HttpServletResponse response;
//
//    @RequestMapping("/home")
//    public String homePage(){
//        return "index";
//    }
//
//    @RequestMapping("/test")
//    public String test(){
//        return "test";
//    }
//
//    @RequestMapping("/toPdfFile")
//    public String toPdfFile(){
//        File file = new File("F:\\apacheOpenOffice\\112233.docx");//需要转换的文件
//        try {
//            File newFile = new File("F:\\apacheOpenOffice\\");//转换之后文件生成的地址
//            if (!newFile.exists()) {
//                newFile.mkdirs();
//            }
//            //文件转化
//            converter.convert(file).to(new File("D:/obj-pdf/hello.pdf")).execute();
//            //使用response,将pdf文件以流的方式发送的前段
//            ServletOutputStream outputStream = response.getOutputStream();
//            InputStream in = new FileInputStream(new File("D:/obj-pdf/hello.pdf"));// 读取文件
//            // copy文件
//            int i = IOUtils.copy(in, outputStream);
//            System.out.println(i);
//            in.close();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "This is to pdf";
//    }
//}
