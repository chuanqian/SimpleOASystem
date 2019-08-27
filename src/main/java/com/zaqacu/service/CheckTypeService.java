package com.zaqacu.service;

import com.zaqacu.entity.CheckType;

import java.util.HashMap;
import java.util.List;

public interface CheckTypeService {
    HashMap<String, Object> getAllCheckTypeBySql(CheckType checkType);

    boolean editCheckType(CheckType checkType);

    boolean addCheckType(CheckType checkType);

    boolean removeCheckType(String ids);

    List<CheckType> getAllCheckTypeList();

}
