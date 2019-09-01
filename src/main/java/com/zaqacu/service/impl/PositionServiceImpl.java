package com.zaqacu.service.impl;

import com.zaqacu.dao.DepartmentMapper;
import com.zaqacu.dao.PositionMapper;
import com.zaqacu.entity.Position;
import com.zaqacu.entitydto.PositionDto;
import com.zaqacu.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Position getOnePositionById(int positionId) {
        return positionMapper.selectByPrimaryKey(positionId);
    }

    @Override
    public Position getOnePosotionByPosition(String positionName) {
        return positionMapper.selectByPositionName(positionName);
    }

    /**
     * 获取全部职位
     * @return
     */
    @Override
    public List<Position> getAllPositionBB() {
        List<Position> positions = positionMapper.seleftAllPositionBB();
        List<Position> positionList = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            if(positions.get(i).getPositionExitsnum()!=positions.get(i).getPositionTotal()){
                Position position = new Position();
                position.setPositionId(positions.get(i).getPositionId());
                position.setPositionName(positions.get(i).getPositionName() + " 缺 " + positions.get(i).getPositionLacknum());
                position.setPositionDepartmentId(positions.get(i).getPositionDepartmentId());
                position.setPositionTotal(positions.get(i).getPositionTotal());
                position.setPositionExitsnum(positions.get(i).getPositionExitsnum());
                position.setPositionLacknum(positions.get(i).getPositionLacknum());
                positionList.add(position);
            }
        }
        return positionList;
    }

    /**
     * 修改职位
     * @param positionId 职位编号
     * @return
     */
    @Override
    public boolean editPositionNumByPositionId(int positionId) {
        Position position = positionMapper.selectByPrimaryKey(positionId);
        position.setPositionExitsnum(position.getPositionExitsnum() + 1);
        position.setPositionLacknum(position.getPositionLacknum() - 1);
        boolean b2 = positionMapper.updateByPrimaryKeySelective(position) != 1 ? false : true;
        return b2;
    }

    /**
     * 修改职位通过id
     * @param positionId 职位id
     * @return
     */
    @Override
    public boolean editPositionNumByJ(int positionId) {
        return positionMapper.updatePositionNumByJ(positionId)!=1?false:true;
    }

    /**
     * 修改人数
     * @param positionNameList 职位名称
     * @return
     */
    @Override
    public boolean editPositionNumByPositionName(List<String> positionNameList) {
        return positionMapper.updatePositionNumByPositionName(positionNameList)!=0?true:false;
    }

    /**
     * 删除职位
     * @param positionIds 职位ids
     * @return
     */
    @Override
    public boolean removePositionBatch(String positionIds) {
        String[] pids = positionIds.split(",");
        List<Integer> pidList = new ArrayList<>();
        for(int i=0;i<pids.length;i++){
            pidList.add(Integer.parseInt(pids[i].trim()));
        }
        return positionMapper.deletePositionBatch(pidList)==0?false:true;
    }


    /**
     * 分页查询调动记录
     * @param position 职位
     * @return
     */
    @Override
    public HashMap<String,Object> getAllPositionBySql(Position position) {
        System.out.println("gdfdfdsfgdsgdfs");
        HashMap<String,Object> map=new HashMap<>();
        position.setStart((position.getPage()-1)*position.getRows());
        System.out.println(position.getPage());
        System.out.println(position.getRows());
        List<Position> positions=positionMapper.selectAllPositionBySql(position);
        System.out.println(positions);
        List<PositionDto> positionDtos=new ArrayList<>();
        for(int i=0;i<positions.size();i++){
            PositionDto positionDto=new PositionDto();
            positionDto.setPositionId(positions.get(i).getPositionId());
            positionDto.setPositionName(positions.get(i).getPositionName());
            positionDto.setPositionTotal(positions.get(i).getPositionTotal());
            positionDto.setPositionLacknum(positions.get(i).getPositionLacknum());
            positionDto.setPositionExitsnum(positions.get(i).getPositionExitsnum());
            positionDto.setDepartment(departmentMapper.selectByPrimaryKey(positions.get(i).getPositionDepartmentId()));
            System.out.println(departmentMapper.selectByPrimaryKey(positions.get(i).getPositionDepartmentId()));
            positionDtos.add(positionDto);
        }
        int total=positionMapper.selectCountPosition();
        map.put("total",total);
        map.put("rows",positionDtos);
        return map;
    }

    /**
     * 修改
     * @param position 职位
     * @return
     */
    @Override
    public boolean editByPrimaryKeySelective(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position)!=1?false:true;
    }

    /**
     * 增加
     * @param position
     * @return
     */
    @Override
    public boolean addPosition(Position position) {
        return positionMapper.insertSelective(position)!=1?false:true;
    }


}
