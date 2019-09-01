package com.zaqacu.controller;

import com.zaqacu.entity.Role;
import com.zaqacu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取全部的角色信息
     * @return
     */
    @RequestMapping("getAllRole.role")
    @ResponseBody
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }

}
