package com.zaqacu.entity;

public class TrainingType {

    private Integer trainingTypeId;

    private String trainingTupeName;

    public Integer getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(Integer trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public String getTrainingTupeName() {
        return trainingTupeName;
    }

    public void setTrainingTupeName(String trainingTupeName) {
        this.trainingTupeName = trainingTupeName == null ? null : trainingTupeName.trim();
    }

}