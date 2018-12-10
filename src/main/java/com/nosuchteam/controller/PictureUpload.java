package com.nosuchteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
 * 2018/12/7
 * 21:49
 */
@Controller
public class PictureUpload {
    @ResponseBody
    @RequestMapping("pic/upload")
    public Map pictureUpload(MultipartFile uploadFile, HttpServletRequest request){

            String realPath = request.getSession().getServletContext().getRealPath("/");
            String path="";
            if (!uploadFile.isEmpty()){
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //下面这一步是获取上传文件的类型，我们可以在这判断是不是图片类型，如果不是的话
                //我们就不进行下一步
//                String contentType = uploadFile.getContentType();
                String originalFilename = uploadFile.getOriginalFilename();
                //下面这一步，是我们获取文件的后缀名称
                String pictureName = originalFilename.substring(originalFilename.indexOf(".") + 1);
                path="pic/"+uuid+"."+pictureName;
                File file = new File(realPath+"/"+path);
                if (file.exists()==false){
                    file.mkdirs();
                }
                try {
                    uploadFile.transferTo(new File(realPath+path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HashMap<String, Object> map = new HashMap();
                map.put("error",0);
                map.put("url",path);
                return map;
            }
            System.out.println(path);
            System.out.println(realPath);


        return null;
    }
    @ResponseBody
    @RequestMapping("pic/delete")
    public Map deletePicture(String picName){
        HashMap<Object, Object> map = new HashMap();
        if (picName!=null){
            map.put("data","success");
            return map;
        }
    return null;
    }
}
