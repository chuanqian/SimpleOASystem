package com.zaqacu.service;

import com.zaqacu.entity.Position;

import java.util.HashMap;
import java.util.List;

public interface PositionService {
    Position getOnePositionById(int positionId);

    Position getOnePosotionByPosition(String positionName);

    List<Position> getAllPositionBB();

    boolean editPositionNumByPositionId(int positionId);

    boolean editPositionNumByJ(int positionId);

    boolean editPositionNumByPositionName(List<String> positionNameList);

    boolean removePositionBatch(String positionIds);

    HashMap<String, Object> getAllPositionBySql(Position position);

    boolean editByPrimaryKeySelective(Position position);

    boolean addPosition(Position position);

}
