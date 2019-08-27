package com.zaqacu.entity;

public class Training extends MyPage {

    private Integer trainingId;

    private Integer trainTypeId;

    private String trainStaffUid;

    private Integer trainingStaffResultId;

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Integer getTrainTypeId() {
        return trainTypeId;
    }


    public void setTrainTypeId(Integer trainTypeId) {
        this.trainTypeId = trainTypeId;
    }


    public String getTrainStaffUid() {
        return trainStaffUid;
    }


    public void setTrainStaffUid(String trainStaffUid) {
        this.trainStaffUid = trainStaffUid == null ? null : trainStaffUid.trim();
    }


    public Integer getTrainingStaffResultId() {
        return trainingStaffResultId;
    }

    public void setTrainingStaffResultId(Integer trainingStaffResultId) {
        this.trainingStaffResultId = trainingStaffResultId;
    }
}