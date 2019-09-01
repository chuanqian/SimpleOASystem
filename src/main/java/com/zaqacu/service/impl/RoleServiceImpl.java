package com.zaqacu.service.impl;

import com.zaqacu.dao.RoleMapper;
import com.zaqacu.entity.Role;
import com.zaqacu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.selectAllRole();
    }
}
