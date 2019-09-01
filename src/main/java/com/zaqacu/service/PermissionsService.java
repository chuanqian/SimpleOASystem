package com.zaqacu.service;

import java.util.List;

public interface PermissionsService {
    void removeByIdandRoleId(int permissionsUserloginId);

    boolean addPermissions(int permissionsUserloginId, List<Integer> permissionsRoleIdList);
}
