package com.zaqacu.service;

import com.zaqacu.entity.Training;

import java.util.List;

public interface TrainingService {
    Training getOneTrainingById(int trainingId);

    boolean removeByStaffUid(String staffUid);

    Training getTrainingByStaffUid(String staffUid);

    List<Training> getByStaffUidList(List<String> staffUidList);

    boolean removeTrainingBatch(List<String> staffUidList);
}
