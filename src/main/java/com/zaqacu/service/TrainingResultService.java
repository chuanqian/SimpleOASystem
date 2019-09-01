package com.zaqacu.service;

import com.zaqacu.entity.TrainingResult;

public interface TrainingResultService {
    /**
     * 培训结果
     * @param trainingResultId
     * @return
     */
    TrainingResult getOneTrainingResult(int trainingResultId);
}
