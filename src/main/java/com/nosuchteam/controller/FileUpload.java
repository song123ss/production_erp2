package com.nosuchteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * yuexia
 * 2018/12/8
 * 10:28
 */
@Controller
public class FileUpload {
    @RequestMapping("file/upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile file, HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String path="";
        if (!file.isEmpty()){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //下面这一步是获取上传文件的类型，我们可以在这判断是不是图片类型，如果不是的话
            //我们就不进行下一步
//                String contentType = uploadFile.getContentType();
            String originalFilename = file.getOriginalFilename();
            //下面这一步，是我们获取文件的后缀名称
//            String pictureName = originalFilename.substring(originalFilename.indexOf(".") + 1);
            path="file/"+uuid+originalFilename;
            File file1 = new File(realPath+File.separator+path);
            if (file1.exists()==false){
                file1.mkdirs();
            }
            try {
                file.transferTo(new File(realPath+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            HashMap<String, Object> map = new HashMap();
            map.put("error",0);
            map.put("url",path);
            return map;
        }
        return null;
    }
    @RequestMapping("file/delete")
    @ResponseBody
    public Map fileDelete(String fileName){
        HashMap<String, Object> map = new HashMap();
        if (fileName!=null){
            map.put("data","success");
            return map;
        }else return null;
    }

}
