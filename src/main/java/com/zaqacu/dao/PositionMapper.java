package com.zaqacu.dao;

import com.zaqacu.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {

    int deleteByPrimaryKey(Integer positionId);

    int deletePositionBatch(@Param("positionList") List<Integer> positionList);


    int insert(Position record);


    int insertSelective(Position record);


    Position selectByPrimaryKey(Integer positionId);

    Position selectByPositionName(String positionName);

    /**
     * 查询全部职位
     * @return
     */
    List<Position> seleftAllPositionBB();

    /**
     * 分页查询Position
     * @param position
     * @return
     */
    List<Position> selectAllPositionBySql(Position position);

    /**
     * 查询总条数
     * @return
     */
    int selectCountPosition();


    int updateByPrimaryKeySelective(Position record);


    int updateByPrimaryKey(Position record);

    int updatePositionNumByJ(int positionId);

    int updatePositionNumByPositionName(@Param("positionNameList") List<String> positionNameList);
}