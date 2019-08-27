package com.zaqacu.service.impl;

import com.zaqacu.dao.TrainingMapper;
import com.zaqacu.entity.Training;
import com.zaqacu.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    public Training getOneTrainingById(int trainingId) {
        return trainingMapper.selectByPrimaryKey(trainingId);
    }

    @Override
    public boolean removeByStaffUid(String staffUid) {
        boolean flag = false;
        int index = trainingMapper.deleteByStaffUid(staffUid);
        if (index != 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Training getTrainingByStaffUid(String staffUid) {
        return trainingMapper.selectByStaffUid(staffUid);
    }

    @Override
    public List<Training> getByStaffUidList(List<String> staffUidList) {
        return trainingMapper.selectByStaffUidList(staffUidList);
    }

    @Override
    public boolean removeTrainingBatch(List<String> staffUidList) {
        return trainingMapper.deleteBatch(staffUidList) == 0 ? false : true;
    }
}
