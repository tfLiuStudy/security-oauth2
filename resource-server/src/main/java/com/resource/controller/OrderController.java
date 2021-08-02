package com.resource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.resource.model.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限方可访问此url
    public String r1(){
        //获取用户身份信息
        String userInfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        UserDTO userDTO = JSON.parseObject(userInfo).toJavaObject(UserDTO.class);
        return userDTO.getFullname()+"访问资源1";
    }

    @PreAuthorize("hasAuthority('p2')")
    @GetMapping(value = "/r2")
    public String r2(){//通过Spring Security API获取当前登录用户
        UserDTO user =
                (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername() + "访问资源2";
    }
}
