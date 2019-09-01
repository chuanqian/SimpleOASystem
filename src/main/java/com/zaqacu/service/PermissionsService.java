package com.zaqacu.service;

import java.util.List;

public interface PermissionsService {
    /**
     * 删除权限
     * @param permissionsUserloginId 权限编号
     */
    void removeByIdandRoleId(int permissionsUserloginId);

    /**
     * 增加全校信息
     * @param permissionsUserloginId 权限用户id
     * @param permissionsRoleIdList 权限角色
     * @return
     */
    boolean addPermissions(int permissionsUserloginId, List<Integer> permissionsRoleIdList);
}
