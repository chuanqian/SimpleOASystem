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

    /**
     * 删除权限
     * @param permissionsUserloginId 权限编号
     */
    @Override
    public void removeByIdandRoleId(int permissionsUserloginId) {
        permissionsMapper.deleteByIdandRoleId(permissionsUserloginId);
    }

    /**
     * 增加权限
     * @param permissionsUserloginId 权限用户id
     * @param permissionsRoleIdList 权限角色
     * @return
     */
    @Override
    public boolean addPermissions(int permissionsUserloginId, List<Integer> permissionsRoleIdList) {
        return permissionsMapper.insertPermissions(permissionsUserloginId, permissionsRoleIdList) != 0 ? true : false;
    }
}
