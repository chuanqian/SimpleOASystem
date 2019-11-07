package com.zaqacu.service.impl;

import com.zaqacu.dao.StaffMapper;
import com.zaqacu.entity.Staff;
import com.zaqacu.entity.StaffArchives;
import com.zaqacu.entity.StaffPact;
import com.zaqacu.entity.UserLogin;
import com.zaqacu.entitydto.StaffDto;
import com.zaqacu.service.*;
import com.zaqacu.util.SaltUtils;
import com.zaqacu.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private StaffStatusService staffStatusService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingResultService trainingResultService;
    @Autowired
    private StaffPactService staffPactService;
    @Autowired
    private StaffArchivesService staffArchivesService;
    @Autowired
    private LoginAndOutService loginAndOutService;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private CheckStaffStatusService checkStaffStatusService;
    @Autowired
    private PermissionsService permissionsService;

    /**
     * 分页查询员工信息
     * @param staff 员工
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public HashMap<String, Object> getAllStaff(Staff staff) {
        HashMap<String, Object> map = new HashMap<>();
        staff.setStart((staff.getPage() - 1) * staff.getRows());
        List<Staff> staffList = staffMapper.selectAllStaffBySql(staff);
        List<StaffDto> staffDtos = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            StaffDto staffDto = new StaffDto();
            staffDto.setStaffUid(staffList.get(i).getStaffUid());
            staffDto.setStaffName(staffList.get(i).getStaffName());
            staffDto.setStaffSex(staffList.get(i).getStaffSex());
            staffDto.setStaffBirth(staffList.get(i).getStaffBirth());
            staffDto.setStaffPhone(staffList.get(i).getStaffPhone());
            staffDto.setStaffEmail(staffList.get(i).getStaffEmail());
            staffDto.setStaffXueli(staffList.get(i).getStaffXueli());
            staffDto.setStaffInTime(staffList.get(i).getStaffInTime());
            staffDto.setStaffNote(staffList.get(i).getStaffNote());
            staffDto.setPosition(positionService.getOnePositionById(staffList.get(i).getStaffPosition()));
            staffDto.setStaffStatus(staffStatusService.getOneStaffStatusById(staffList.get(i).getStaffStatusId()));
            staffDto.setDepartment(departmentService.getOneDepartmentById(staffList.get(i).getStaffDepartmentId()));
            if (trainingService.getOneTrainingById(staffList.get(i).getStaffTrainingId()) != null) {
                staffDto.setTraining(trainingService.getOneTrainingById(staffList.get(i).getStaffTrainingId()));
                staffDto.setTrainingResult(trainingResultService.getOneTrainingResult(trainingService.getOneTrainingById(staffList.get(i).getStaffTrainingId()).getTrainingStaffResultId()).getTrainingResult());
            } else {
                staffDto.setTrainingResult("未培训");
            }
            staffDtos.add(staffDto);
        }
        int total = staffMapper.selectCountStaff();
        map.put("total", total);
        map.put("rows", staffDtos);
        return map;
    }

    /**
     * 通过id获取员工
     * @param StaffUid 员工编号
     * @return
     */
    @Override
    public Staff getOneStaffByUid(String StaffUid) {
        return staffMapper.selectByPrimaryKey(StaffUid);
    }

    /**
     * 删除员工
     * @param staffIds 员工编号
     * @param positionNames 职位名称
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean removeStaff(String staffIds, String positionNames) {
        String[] ids = staffIds.split(",");
        String[] pnms = positionNames.split(",");
        List<String> staffUidList = new ArrayList<>();
        List<String> pnmsList = new ArrayList<>();
        Collections.addAll(staffUidList, ids);
        Collections.addAll(pnmsList, pnms);
        boolean flag1 = true;
        if (trainingService.getByStaffUidList(staffUidList) != null) {
            flag1 = trainingService.removeTrainingBatch(staffUidList);
        }
        boolean flag2 = staffPactService.removeBatch(staffUidList);
        boolean flag3 = staffArchivesService.removeBatch(staffUidList);
        //考勤
        boolean flag4 = staffMapper.deleteBatch(staffUidList) == 0 ? false : true;
        boolean flag5 = positionService.editPositionNumByPositionName(pnmsList);
        boolean flag6 = loginAndOutService.deleteByStaffUidList(staffUidList);

        boolean flag7 = personnelService.removeBatchByStaffUid(staffUidList);
        boolean flag8 = checkStaffStatusService.removeBatchByStaffUid(staffUidList);
//            System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
        System.out.println(flag5);
        System.out.println(flag6);
        return flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag8;

    }

    /**
     * 增加员工
     * @param userName
     * @param userPassword
     * @param staffName
     * @param staffSex
     * @param staffBirth
     * @param staffPhone
     * @param staffEmail
     * @param staffXueli
     * @param staffPosition
     * @param staffInTime
     * @param staffStatusId
     * @param staffNote
     * @param archivesName
     * @param archivesInfo
     * @param archivesNote
     * @param pactCreateTime
     * @param pactEndTime
     * @param pactInfo
     * @param pactNote
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean addStaff(String userName, String userPassword,
                            String staffName, String staffSex, String staffBirth, String staffPhone,
                            String staffEmail, String staffXueli, String staffPosition,
                            String staffInTime, String staffStatusId, String staffNote, String archivesName,
                            String archivesInfo, String archivesNote, String pactCreateTime, String pactEndTime,
                            String pactInfo, String pactNote) {
        if (!loginAndOutService.getOneUserLoginByUserName(userName)) {
            return false;
        }
        String saltPassword = SaltUtils.getSaltPassword(userPassword, userName);
        String staffUid = UUIDUtils.getOneUUId();
        UserLogin userLogin = new UserLogin();
        userLogin.setUserPermissionsId(1);
        userLogin.setUserName(userName);
        userLogin.setUserPassword(saltPassword);
        userLogin.setStaffUid(staffUid);
        Staff staff = new Staff();
        staff.setStaffUid(staffUid);
        staff.setStaffName(staffName);
        staff.setStaffSex(staffSex);
        staff.setStaffBirth(staffBirth);
        staff.setStaffPhone(staffPhone);
        staff.setStaffEmail(staffEmail);
        staff.setStaffXueli(staffXueli);
        staff.setStaffPosition(Integer.parseInt(staffPosition.trim()));
        staff.setStaffDepartmentId(positionService.getOnePositionById(Integer.parseInt(staffPosition.trim())).getPositionDepartmentId());
        staff.setStaffInTime(staffInTime);
        staff.setStaffStatusId(Integer.parseInt(staffStatusId.trim()));
        staff.setStaffNote(staffNote);
        StaffArchives staffArchives = new StaffArchives();
        staffArchives.setArchivesName(archivesName);
        staffArchives.setArchivesInfo(archivesInfo);
        staffArchives.setArchivesNote(archivesNote);
        staffArchives.setArcivesStaffUid(staffUid);
        StaffPact staffPact = new StaffPact();
        staffPact.setPactStaffUid(staffUid);
        staffPact.setPactCreateTime(pactCreateTime);
        staffPact.setPactEndTime(pactEndTime);
        staffPact.setPactInfo(pactInfo);
        staffPact.setPactNote(pactNote);
        staffPact.setPactStaffPositionId(Integer.parseInt(staffPosition.trim()));
        boolean b1 = loginAndOutService.addUserLogin(userLogin);
        boolean b2 = staffArchivesService.addStaffArchives(staffArchives);
        boolean b3 = staffPactService.addStaffPact(staffPact);
        boolean b4 = staffMapper.insertSelective(staff) != 1 ? false : true;
        boolean b5 = positionService.editPositionNumByPositionId(Integer.parseInt(staffPosition.trim()));
        boolean b6 = checkStaffStatusService.addCheckStaffStatusByStaffUid(staffUid);
        return b1 && b2 && b3 && b4 && b5 && b6;
    }

    /**
     * 修改员工
     * @param staff 员工
     * @return
     */
    @Override
    public boolean editStaff(Staff staff) {
        System.out.println("fgdfasdfdf");
        return staffMapper.updateByPrimaryKeySelective(staff) != 1 ? false : true;
    }

    /**
     * 获取全部员工
     * @param staff
     * @return
     */
    @Override
    public List<Staff> getAllStaffByPersonnel(Staff staff) {
        return staffMapper.selectAllStaffByPersonnel(staff);
    }

    /**
     * 根据职位获取员工
     * @param positionName 职位名称
     * @return
     */
    @Override
    public List<String> getAllPositionByPositionName(String positionName) {
        return staffMapper.selectAllPositionByPositionName(positionName);
    }

    /**
     * 查询员工总条数
     * @return
     */
    @Override
    public int getCountStaff() {
        return staffMapper.selectCountStaff();
    }

    /**
     * 获取员工信息
     * @param staffUidList 员工编号ids
     * @return
     */
    @Override
    public List<Staff> getAllStaffByStaffUidList(List<String> staffUidList) {
        return staffMapper.selectAllStaffByStaffUidList(staffUidList);
    }

    /**
     * 授权
     * @param staffUid 员工编号
     * @param StaffName 员工信息
     * @param roleIds 角色编号
     * @return
     */
    @Override
    public boolean toGiveEnable(String staffUid, String StaffName, String roleIds) {
        int userId = loginAndOutService.getByStaffUid(staffUid);
        String[] roleids=roleIds.split(",");
        List<Integer> roles=new ArrayList<>();
        for (String roleid : roleids) {
            roles.add(Integer.parseInt(roleid.trim()));
        }
        permissionsService.removeByIdandRoleId(userId);
        return permissionsService.addPermissions(userId,roles);
    }


}
