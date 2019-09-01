package com.zaqacu.service.impl;

import com.zaqacu.dao.BasicMoneyMapper;
import com.zaqacu.entity.BasicMoney;
import com.zaqacu.service.BasicMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BasicMoneyServiceImpl implements BasicMoneyService {

    @Autowired
    private BasicMoneyMapper basicMoneyMapper;

    /**
     * 分页查询基本工资信息
     * @param basicMoney 基本工资
     * @return
     */
    @Override
    public HashMap<String, Object> getAllBasicMoneyBySql(BasicMoney basicMoney) {
        HashMap<String,Object> map=new HashMap<>();
        basicMoney.setStart((basicMoney.getPage()-1)*basicMoney.getRows());
        List<BasicMoney> basicMoneyList = basicMoneyMapper.selectAllBasicMoneyBySql(basicMoney);
        int total=basicMoneyMapper.selectAllBasicCount();
        map.put("total",total);
        map.put("rows",basicMoneyList);
        return map;
    }

    /**
     * 修改金额
     * @param basicMoney 金额
     * @return
     */
    @Override
    public boolean editByPrimaryKeySelective(BasicMoney basicMoney) {
        return basicMoneyMapper.updateByPrimaryKeySelective(basicMoney) != 0 ? true : false;
    }

    /**
     * 删除
     * @param ids id数组
     * @return
     */
    @Override
    public boolean removeBasicMoneyBatch(String ids) {
        String[] idss = ids.split(",");
        List<Integer> basicMoneyIds = new ArrayList<>();
        for (String s : idss) {
            basicMoneyIds.add(Integer.parseInt(s.trim()));
        }
        return basicMoneyMapper.deleteBasicMoneyBatch(basicMoneyIds) != 0 ? true : false;
    }

    /**
     * 增加
     * @param record
     * @return
     */
    @Override
    public boolean addSelective(BasicMoney record) {
        return basicMoneyMapper.insertSelective(record) != 0 ? true : false;
    }

    /**
     * 获取全部
     * @return
     */
    @Override
    public List<BasicMoney> getAllBasicMoney() {
        return basicMoneyMapper.selectAllBasicMoney();
    }

    /**
     * 通过id查询
     * @param basicMoneyId
     * @return
     */
    @Override
    public double getOneBasicMoneyById(int basicMoneyId) {
        return basicMoneyMapper.selectOneBasicMoneyById(basicMoneyId);
    }

    /**
     * 通过id获取
     * @param basicMoneyId
     * @return
     */
    @Override
    public BasicMoney getByPrimaryKey(int basicMoneyId) {
        return basicMoneyMapper.selectByPrimaryKey(basicMoneyId);
    }
}
