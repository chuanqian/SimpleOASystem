package com.zaqacu.dao;

import com.zaqacu.entity.TrainingResult;

public interface TrainingResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    int deleteByPrimaryKey(Integer trainingResultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    int insert(TrainingResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    int insertSelective(TrainingResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    TrainingResult selectByPrimaryKey(Integer trainingResultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    int updateByPrimaryKeySelective(TrainingResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table training_result
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    int updateByPrimaryKey(TrainingResult record);
}