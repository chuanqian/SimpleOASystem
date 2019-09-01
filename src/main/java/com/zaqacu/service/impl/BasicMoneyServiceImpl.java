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

    @Override
    public boolean editByPrimaryKeySelective(BasicMoney basicMoney) {
        return basicMoneyMapper.updateByPrimaryKeySelective(basicMoney) != 0 ? true : false;
    }

    @Override
    public boolean removeBasicMoneyBatch(String ids) {
        String[] idss = ids.split(",");
        List<Integer> basicMoneyIds = new ArrayList<>();
        for (String s : idss) {
            basicMoneyIds.add(Integer.parseInt(s.trim()));
        }
        return basicMoneyMapper.deleteBasicMoneyBatch(basicMoneyIds) != 0 ? true : false;
    }

    @Override
    public boolean addSelective(BasicMoney record) {
        return basicMoneyMapper.insertSelective(record) != 0 ? true : false;
    }

    @Override
    public List<BasicMoney> getAllBasicMoney() {
        return basicMoneyMapper.selectAllBasicMoney();
    }

    @Override
    public double getOneBasicMoneyById(int basicMoneyId) {
        return basicMoneyMapper.selectOneBasicMoneyById(basicMoneyId);
    }

    @Override
    public BasicMoney getByPrimaryKey(int basicMoneyId) {
        return basicMoneyMapper.selectByPrimaryKey(basicMoneyId);
    }
}
