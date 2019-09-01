package com.zaqacu.service.impl;

import com.zaqacu.dao.PermissionsMapper;
import com.zaqacu.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;


    @Override
    public void removeByIdandRoleId(int permissionsUserloginId) {
        permissionsMapper.deleteByIdandRoleId(permissionsUserloginId);
    }

    @Override
    public boolean addPermissions(int permissionsUserloginId, List<Integer> permissionsRoleIdList) {
        return permissionsMapper.insertPermissions(permissionsUserloginId, permissionsRoleIdList) != 0 ? true : false;
    }
}
