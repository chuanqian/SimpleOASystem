package com.zaqacu.service.impl;

import com.zaqacu.dao.PersonnelMapper;
import com.zaqacu.entity.Personnel;
import com.zaqacu.entity.Position;
import com.zaqacu.entity.Staff;
import com.zaqacu.entitydto.PersonnelDto;
import com.zaqacu.service.PersonnelService;
import com.zaqacu.service.PositionService;
import com.zaqacu.service.StaffService;
import com.zaqacu.util.TimeUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private PersonnelMapper personnelMapper;

    /**
     * 查询考勤员工信息
     * @param staff 员工
     * @return
     */
    @Override
    public HashMap<String,Object> getAllStaffAndPosition(Staff staff) {
        staff.setStart((staff.getPage()-1)*staff.getRows());
        List<Staff> staffList = staffService.getAllStaffByPersonnel(staff);
        List<PersonnelDto> personnelDtos = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            PersonnelDto personnelDto = new PersonnelDto();
            Position onePositionById = positionService.getOnePositionById(staffList.get(i).getStaffPosition());
            personnelDto.setPosition(onePositionById);
            personnelDto.setStaff(staffList.get(i));
            personnelDto.setPersonnelStaffUid(staffList.get(i).getStaffUid());
            personnelDto.setsName(staffList.get(i).getStaffName());
            personnelDto.setPositionName(onePositionById.getPositionName());
            personnelDto.setPersonnelOldPositionId(onePositionById.getPositionId());
            personnelDto.setStaffInTime(staffList.get(i).getStaffInTime());
            personnelDtos.add(personnelDto);
        }
        int total=staffService.getCountStaff();
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("rows",personnelDtos);
        return map;
    }

    /**
     * 增加人事调动记录
     * @param personnelStaffUid 调动员工编号
     * @param sName 名称
     * @param positionName 职位
     * @param personnelNewPositionId 新职位id
     * @param personnelCause 原因
     * @return
     */
    @Override
    public boolean editPersonnelByPosition(String personnelStaffUid, String sName, String positionName, String personnelNewPositionId, String personnelCause) {
//
//        System.out.println(personnelStaffUid);
//        System.out.println(sName);
//        System.out.println(positionName);
//        System.out.println(personnelCause);
//        System.out.println(personnelNewPositionId);

        Staff staff = new Staff();
        staff.setStaffUid(personnelStaffUid);
        staff.setStaffPosition(Integer.parseInt(personnelNewPositionId.trim()));
        boolean b1 = staffService.editStaff(staff);

        int i = Integer.parseInt(personnelNewPositionId.trim());
        int j = positionService.getOnePosotionByPosition(positionName.trim()).getPositionId();
        if (i != j) {
            positionService.editPositionNumByPositionId(i);
            positionService.editPositionNumByJ(j);
        }
        Personnel personnel = new Personnel();
        personnel.setPersonnelStaffUid(personnelStaffUid);
        personnel.setPersonnelTime(new Date());
        personnel.setPersonnelCause(personnelCause);
        personnel.setPersonnelNewPositionId(i);
        personnel.setPersonnelOldPositionId(j);
        boolean b2 = personnelMapper.insertSelective(personnel) != 1 ? false : true;
        return b1 && b2;
    }

    /**
     * 分页获取全部信息
     * @param personnel 人事
     * @return
     */
    @Override
    public HashMap<String, Object> getAllPersonnelBySql(Personnel personnel) {
        HashMap<String, Object> map = new HashMap<>();
        personnel.setStart((personnel.getPage() - 1) * personnel.getRows());
        List<Personnel> personnels = personnelMapper.selectPersonnelBySql(personnel);
        List<PersonnelDto> personnelDtos = new ArrayList<>();
        for (int i = 0; i < personnels.size(); i++) {
            PersonnelDto personnelDto = new PersonnelDto();
            personnelDto.setPersonnelId(personnels.get(i).getPersonnelId());
            personnelDto.setStaff(staffService.getOneStaffByUid(personnels.get(i).getPersonnelStaffUid()));
            personnelDto.setPersonnelStaffUid(personnels.get(i).getPersonnelStaffUid());
            personnelDto.setPersonnelCause(personnels.get(i).getPersonnelCause());
            personnelDto.setPersonnelTime(TimeUtls.getTimeParse(personnels.get(i).getPersonnelTime()));
            personnelDto.setOldName(positionService.getOnePositionById(personnels.get(i).getPersonnelOldPositionId()).getPositionName());
            personnelDto.setNewNmae(positionService.getOnePositionById(personnels.get(i).getPersonnelNewPositionId()).getPositionName());
//            System.out.println(personnelDto.getNewNmae());
            personnelDtos.add(personnelDto);
        }
        int total = personnelMapper.getAllCouunt();
        map.put("total", total);
        map.put("rows", personnelDtos);
        return map;
    }

    /**
     * 删除
     * @param personnelIds 人事记录编号数组
     * @return
     */
    @Override
    public boolean removePersonnel(String personnelIds) {
        System.out.println(personnelIds);
        String[] strIds = personnelIds.split(",");
        Integer[] ids = new Integer[strIds.length];
        List<Integer> perids = new ArrayList<>();
        for (int i = 0; i < strIds.length; i++) {
            ids[i] = Integer.parseInt(strIds[i].trim());
        }
        Collections.addAll(perids, ids);
        return personnelMapper.deleteBatch(perids) != 0 ? true : false;

    }

    /**
     * 批量删除
     * @param staffUidList 员工编号
     * @return
     */
    @Override
    public boolean removeBatchByStaffUid(List<String> staffUidList) {
        return personnelMapper.deleteBatchByStaffUid(staffUidList) != 0 ? true : false;
    }


}
