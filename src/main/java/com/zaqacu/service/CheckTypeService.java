package com.zaqacu.service;

import com.zaqacu.entity.CheckType;

import java.util.HashMap;
import java.util.List;

public interface CheckTypeService {
    /**
     * 分页获取考勤类型
     * @param checkType
     * @return
     */
    HashMap<String, Object> getAllCheckTypeBySql(CheckType checkType);

    /**
     * 修改考勤类型
     * @param checkType
     * @return
     */
    boolean editCheckType(CheckType checkType);

    /**
     * 增加考勤类型
     * @param checkType 考勤类型
     * @return
     */
    boolean addCheckType(CheckType checkType);

    /**
     * 删除考考勤类型
     * @param ids ids数组
     * @return
     */
    boolean removeCheckType(String ids);

    /**
     * 获取全部考勤信息
     * @return List
     */
    List<CheckType> getAllCheckTypeList();

}
