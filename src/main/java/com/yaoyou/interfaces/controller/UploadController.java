package com.yaoyou.interfaces.controller;

import com.yaoyou.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by song on 16/8/19.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Resource
    UserService userService;
    @RequestMapping("/avatar/{userId}")
    public String uploadAvatar(@PathVariable String userId, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
        String fileName = upload(file, request);
        userService.setUserImg(userId, fileName);
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);

        return "/user/avatar";
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("upload");
        String origFileName = multipartFile.getOriginalFilename();
        String ext = origFileName.substring(origFileName.lastIndexOf("."));
        String fileName = System.currentTimeMillis()+ext;
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            multipartFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @RequestMapping("page")
    public String redirect(){
        return "upload";
    }


}
