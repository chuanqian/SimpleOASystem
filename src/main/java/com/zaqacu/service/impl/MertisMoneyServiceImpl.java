package com.zaqacu.service.impl;

import com.zaqacu.dao.MertisMoneyMapper;
import com.zaqacu.entity.MertisMoney;
import com.zaqacu.entitydto.MertisMoneyDto;
import com.zaqacu.service.MertisMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MertisMoneyServiceImpl implements MertisMoneyService {

    @Autowired
    private MertisMoneyMapper mertisMoneyMapper;

    /**
     * 分页查询绩效信息
     * @param mertisMoney 绩效
     * @return
     */
    @Override
    public HashMap<String, Object> getMertisMoneyBySql(MertisMoney mertisMoney) {
        mertisMoney.setStart((mertisMoney.getPage() - 1) * mertisMoney.getRows());
        List<MertisMoney> mertisMoneyList = mertisMoneyMapper.selectMertisMoneyBySql(mertisMoney);
        List<MertisMoneyDto> mertisMoneyDtos=new ArrayList<>();
        for (MertisMoney money : mertisMoneyList) {
            MertisMoneyDto mertisMoneyDto=new MertisMoneyDto();
            mertisMoneyDto.setMertisMoneyId(money.getMertisMoneyId());
            mertisMoneyDto.setMertisMoneyNum(money.getMertisMoneyNum());
            mertisMoneyDto.setMertisPercentage(money.getMertisPercentage());
            mertisMoneyDtos.add(mertisMoneyDto);
        }
        int total = mertisMoneyMapper.selectMertisMoneyCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", mertisMoneyDtos);
        return map;
    }

    /**
     * 修改绩效
     * @param mertisMoneyId 绩效id
     * @param mertisPercentage 绩效百分比
     * @param mertisMoneyNum 绩效金额
     * @return
     */
    @Override
    public boolean editMertisMoneyByMertisId(String mertisMoneyId,String mertisPercentage,String mertisMoneyNum) {
        int index=mertisPercentage.indexOf("%");
        MertisMoney mertisMoney=new MertisMoney();
        mertisMoney.setMertisPercentage(Double.parseDouble(mertisPercentage.substring(0,index).trim())/100);
        mertisMoney.setMertisMoneyNum(Double.parseDouble(mertisMoneyNum.trim()));
        mertisMoney.setMertisMoneyId(Integer.parseInt(mertisMoneyId.trim()));
        return mertisMoneyMapper.updateByPrimaryKeySelective(mertisMoney) != 0 ? true : false;
    }

    /**
     * 删除绩效
     * @param ids 数组id
     * @return
     */
    @Override
    public boolean removeMertisBatch(String ids) {
        String[] mertisids = ids.split(",");
        List<Integer> mertisMoneyIds = new ArrayList<>();
        for (String mertisid : mertisids) {
            mertisMoneyIds.add(Integer.parseInt(mertisid.trim()));
        }
        return mertisMoneyMapper.deleteByMertisIdsBatch(mertisMoneyIds) != 0 ? true : false;
    }

    /**
     * 增加绩效
     * @param mertisPercentage 百分比
     * @param mertisMoneyNum 金额
     * @return
     */
    @Override
    public boolean addOneMertisMoney(String mertisPercentage,String mertisMoneyNum) {

        int index=mertisPercentage.indexOf("%");
        MertisMoney mertisMoney=new MertisMoney();
        mertisMoney.setMertisPercentage(Double.parseDouble(mertisPercentage.substring(0,index).trim())/100);
        mertisMoney.setMertisMoneyNum(Double.parseDouble(mertisMoneyNum.trim()));
        return mertisMoneyMapper.insertSelective(mertisMoney) != 0 ? true : false;
    }

    /**
     * 获得全部绩效
     * @return
     */
    @Override
    public List<MertisMoneyDto> getAllMertisMoney() {
        List<MertisMoney> mertisMoneyList = mertisMoneyMapper.selectAllMertisMoney();
        List<MertisMoneyDto> mertisMoneyDtos=new ArrayList<>();
        for (MertisMoney money : mertisMoneyList) {
            MertisMoneyDto mertisMoneyDto=new MertisMoneyDto();
            mertisMoneyDto.setMertisMoneyId(money.getMertisMoneyId());
            mertisMoneyDto.setMertisMoneyNum(money.getMertisMoneyNum());
            mertisMoneyDto.setMertisPercentage(money.getMertisPercentage());
            mertisMoneyDtos.add(mertisMoneyDto);
        }
        return mertisMoneyDtos;
    }

    /**
     * 获取绩效通过id
     * @param mertisMoneyId 绩效id
     * @return
     */
    @Override
    public double getOneMertisById(int mertisMoneyId) {
        return mertisMoneyMapper.selectOneMertisById(mertisMoneyId);
    }

    /**
     * 通过id获取
     * @param mertisMoneyId 绩效id
     * @return
     */
    @Override
    public MertisMoney getByPrimaryKey(int mertisMoneyId) {
        return mertisMoneyMapper.selectByPrimaryKey(mertisMoneyId);
    }
}
