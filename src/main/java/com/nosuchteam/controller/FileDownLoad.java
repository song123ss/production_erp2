package com.nosuchteam.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * yuexia
 * 2018/12/8
 * 19:35
 */
@Controller
public class FileDownLoad {
    @RequestMapping("file/download")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request) throws IOException {
        String fileName = request.getParameter("fileName");
        System.out.println(fileName);
        String substring = fileName.substring(fileName.indexOf('/')+33);
        String realPath = request.getServletContext().getRealPath("/file/");
        File file = new File(realPath + File.separator + substring);
        HttpHeaders httpHeaders = new HttpHeaders();
        String downloadFileName = new String(substring.getBytes("UTF-8"), "iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment",downloadFileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                httpHeaders, HttpStatus.CREATED);

    }

    /*
    *
    * */
//    @RequestMapping(value="/download")
//    public ResponseEntity<byte[]> download(HttpServletRequest request,
//                                           @RequestParam("filename") String filename,
//                                           Model model)throws Exception {
//        //下载文件路径
//        String path = request.getServletContext().getRealPath("/images/");
//        File file = new File(path + File.separator + filename);
//        HttpHeaders headers = new HttpHeaders();
//        //下载显示的文件名，解决中文名称乱码问题
//        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
//        //通知浏览器以attachment（下载方式）打开图片
//        headers.setContentDispositionFormData("attachment", downloadFielName);
//        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
//                headers, HttpStatus.CREATED);
//    }
}
