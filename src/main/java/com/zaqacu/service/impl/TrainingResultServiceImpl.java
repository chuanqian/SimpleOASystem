package com.zaqacu.service.impl;

import com.zaqacu.dao.TrainingResultMapper;
import com.zaqacu.entity.TrainingResult;
import com.zaqacu.service.TrainingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingResultServiceImpl implements TrainingResultService {

    @Autowired
    private TrainingResultMapper trainingResultMapper;
    @Override
    public TrainingResult getOneTrainingResult(int trainingResultId) {
        return trainingResultMapper.selectByPrimaryKey(trainingResultId);
    }
}
