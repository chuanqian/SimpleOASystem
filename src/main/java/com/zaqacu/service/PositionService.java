package com.zaqacu.service;

import com.zaqacu.entity.Position;

import java.util.HashMap;
import java.util.List;

public interface PositionService {
    /**
     * 通过编号获取职位
     * @param positionId 职位编号
     * @return
     */
    Position getOnePositionById(int positionId);

    /**
     * 通过职位名查询职位信息
     * @param positionName 职位名称
     * @return
     */
    Position getOnePosotionByPosition(String positionName);

    /**
     * 获取全部职位BB
     * @return
     */
    List<Position> getAllPositionBB();

    /**
     * 修改职位
     * @param positionId 职位编号
     * @return
     */
    boolean editPositionNumByPositionId(int positionId);

    /**
     * 修改职位人数
     * @param positionId 职位id
     * @return
     */
    boolean editPositionNumByJ(int positionId);

    /**
     * 通过名称修改职位
     * @param positionNameList 职位名称
     * @return
     */
    boolean editPositionNumByPositionName(List<String> positionNameList);

    /**
     * 删除职位
     * @param positionIds 职位ids
     * @return
     */
    boolean removePositionBatch(String positionIds);

    /**
     * 分页查询职位信息
     * @param position 职位
     * @return
     */
    HashMap<String, Object> getAllPositionBySql(Position position);

    /**
     * 修改职位通过主键
     * @param position 职位
     * @return
     */
    boolean editByPrimaryKeySelective(Position position);

    /**
     * 增加职位
     * @param position
     * @return
     */
    boolean addPosition(Position position);

}
