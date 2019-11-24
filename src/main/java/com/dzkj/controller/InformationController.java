package com.dzkj.controller;

import com.dzkj.pojo.User;
import com.dzkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class InformationController {
    @Autowired
    IUserService userService;

    @RequestMapping("/information")
    public String information() {
        return "person/information";
    }

    @RequestMapping("/update")
    public String updata(User user,MultipartFile url ,HttpServletRequest request) throws IOException {
    	user.setU_pwd(((User)request.getSession().getAttribute("user")).getU_pwd());
        if (url.isEmpty()) {
    //            当头像未进行修改时
                 userService.update(user);
                 User newUser = userService.findById(user.getU_id());
                request.getSession().setAttribute("user",newUser);
        }else {
//            当头像进行修改
            String Put = getPut(url,request);
            user.setU_url(Put);
            userService.update(user);
            User newUser = userService.findById(user.getU_id());
            request.getSession().setAttribute("user",newUser);
        }
        return "redirect:/information";
    }
//    拿图片
    public  String getPut(MultipartFile UserPut,HttpServletRequest request) throws IOException {
        //拿到文件的名字
        String filName = UserPut.getOriginalFilename();
        //设置文件路径
        String filPath = request.getServletContext().getRealPath("img");
        //创建文件对象
        File dest = new File(filPath +"/"+filName);
        //文件上传
        UserPut.transferTo(dest);
        //拿到文件的真实地址
        String Put = "img/"+filName;
        return  Put;
    }
}
