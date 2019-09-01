package com.zaqacu.service;

import com.zaqacu.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取全部职位
     * @return List
     */
    List<Role> getAllRole();

}
