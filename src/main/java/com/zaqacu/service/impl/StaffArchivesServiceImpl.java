package com.zaqacu.service.impl;

import com.zaqacu.dao.StaffArchivesMapper;
import com.zaqacu.entity.StaffArchives;
import com.zaqacu.entitydto.StaffArchivesDto;
import com.zaqacu.service.StaffArchivesService;
import com.zaqacu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StaffArchivesServiceImpl implements StaffArchivesService {

    @Autowired
    private StaffArchivesMapper staffArchivesMapper;
    @Autowired
    private StaffService staffService;

    @Override
    public HashMap<String, Object> getAllStaffArchivesBySql(StaffArchives staffArchives) {
        HashMap<String, Object> map = new HashMap<>();
        staffArchives.setStart((staffArchives.getPage() - 1) * staffArchives.getRows());
        List<StaffArchives> archivesList = staffArchivesMapper.selectAllArchivesBySql(staffArchives);
        List<StaffArchivesDto> archivesDtos = new ArrayList<>();
        for (int i = 0; i < archivesList.size(); i++) {
            StaffArchivesDto archivesDto = new StaffArchivesDto();
            archivesDto.setArchivesId(archivesList.get(i).getArchivesId());
            archivesDto.setStaff(staffService.getOneStaffByUid(archivesList.get(i).getArcivesStaffUid()));
            archivesDto.setArchivesName(archivesList.get(i).getArchivesName());
            archivesDto.setArchivesInfo(archivesList.get(i).getArchivesInfo());
            archivesDto.setArchivesNote(archivesList.get(i).getArchivesNote());
            archivesDtos.add(archivesDto);
        }
        int total = staffArchivesMapper.selectArchivesCount();
        map.put("total", total);
        map.put("rows", archivesDtos);
        return map;
    }

    @Override
    public boolean editStaffArchives(StaffArchives staffArchives) {
        int index = staffArchivesMapper.updateByPrimaryKeySelective(staffArchives);
        if (index != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeStaffArchives(String ids) {
        boolean flag = true;
        String[] archivesIds = ids.split(",");
        for (int i = 0; i < archivesIds.length; i++) {
            int index = staffArchivesMapper.deleteByPrimaryKey(Integer.parseInt(archivesIds[i]));
            if (index == 0) {
                return false;
            }
        }
        return flag;
    }

    @Override
    public boolean removeByStaffUid(String staffUid) {
        boolean flag = false;
        int index = staffArchivesMapper.deleteByStaffUid(staffUid);
        if (index != 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean removeBatch(List<String> staffUidList) {
        return staffArchivesMapper.deleteBatch(staffUidList)==0?false:true;
    }

    @Override
    public boolean addStaffArchives(StaffArchives staffArchives) {
        return staffArchivesMapper.insertSelective(staffArchives) != 1 ? false : true;
    }

}
