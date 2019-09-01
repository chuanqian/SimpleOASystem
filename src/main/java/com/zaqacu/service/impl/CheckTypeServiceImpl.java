package com.zaqacu.service.impl;

import com.zaqacu.dao.CheckTypeMapper;
import com.zaqacu.entity.CheckType;
import com.zaqacu.service.CheckTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class CheckTypeServiceImpl implements CheckTypeService {

    @Autowired
    private CheckTypeMapper checkTypeMapper;

    /**
     * 分页查询考情类型状态
     * @param checkType
     * @return
     */
    @Override
    public HashMap<String, Object> getAllCheckTypeBySql(CheckType checkType) {
        checkType.setStart((checkType.getPage() - 1) * checkType.getRows());
        List<CheckType> checkTypeList = checkTypeMapper.selectAllCheckTypeBySql(checkType);
        int total = checkTypeMapper.selectAllCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", checkTypeList);
        return map;
    }

    /**
     * 修改类型
     * @param checkType
     * @return
     */
    @Override
    public boolean editCheckType(CheckType checkType) {
        return checkTypeMapper.updateByPrimaryKeySelective(checkType) != 0 ? true : false;
    }

    /**
     * 增加类型
     * @param checkType 考勤类型
     * @return
     */
    @Override
    public boolean addCheckType(CheckType checkType) {
        return checkTypeMapper.insertCheckType(checkType) != 0 ? true : false;
    }

    /**
     * 删除类型
     * @param ids ids数组
     * @return
     */
    @Override
    public boolean removeCheckType(String ids) {
        String[] checkTypeIds = ids.split(",");
        Integer[] checkTypes = new Integer[checkTypeIds.length];
        for (int i = 0; i < checkTypeIds.length; i++) {
            checkTypes[i] = Integer.parseInt(checkTypeIds[i].trim());
        }
        List<Integer> typeIds = new ArrayList<>();
        Collections.addAll(typeIds, checkTypes);
        return checkTypeMapper.deleteByCheckTypes(typeIds) != 0 ? true : false;
    }

    /**
     * 获取全部类型
     * @return
     */
    @Override
    public List<CheckType> getAllCheckTypeList() {
        return checkTypeMapper.selectAllCheckType();
    }


}
