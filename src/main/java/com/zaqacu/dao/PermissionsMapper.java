package com.zaqacu.dao;

import com.zaqacu.entity.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer permissionsId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer permissionsId);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
    /**
     * 查询全部权限
     * @return
     */
    List<Permissions> selectAllPermissionsList();

    int deleteByIdandRoleId(int permissionsUserloginId);

    int insertPermissions(@Param("permissionsUserloginId") int permissionsUserloginId, @Param("permissionsRoleIdList") List<Integer> permissionsRoleIdList);


}