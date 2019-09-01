package com.zaqacu.controller;

import com.zaqacu.entity.Department;
import com.zaqacu.entity.Position;
import com.zaqacu.service.DepartmentService;
import com.zaqacu.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "toPosition.position")
    public String toPosition() {
        return "department/position";
    }

    @RequestMapping(value = "getAllPosition.position")
    @ResponseBody
    public List<Position> getAllPosition() {
        return positionService.getAllPositionBB();
    }

    @RequestMapping(value = "getAllPositionBysql.position")
    @ResponseBody
    public HashMap<String, Object> getAllPositionBysql(Position position) {
        if(position.getPositionName()!=null && position.getPositionName()!=""){
            position.setPositionName("%"+position.getPositionName()+"%");
        }
        return positionService.getAllPositionBySql(position);
    }

    @RequestMapping(value = "editPosition.position", method = RequestMethod.POST)
    @ResponseBody
    public boolean editPosition(Position position) {
        Position onePositionById = positionService.getOnePositionById(position.getPositionId());
        if (onePositionById.getPositionDepartmentId() != position.getPositionDepartmentId()) {
            Department oneDepartmentById = departmentService.getOneDepartmentById(onePositionById.getPositionDepartmentId());
            oneDepartmentById.setDepartmentExitsnum(oneDepartmentById.getDepartmentExitsnum() - 1);
            oneDepartmentById.setDepartmentLacknum(oneDepartmentById.getDepartmentLacknum() + 1);
            departmentService.editByPrimaryKeySelective(oneDepartmentById);
            Department oneDepartmentById1 = departmentService.getOneDepartmentById(position.getPositionDepartmentId());
            oneDepartmentById1.setDepartmentExitsnum(oneDepartmentById1.getDepartmentExitsnum() + 1);
            oneDepartmentById1.setDepartmentLacknum(oneDepartmentById1.getDepartmentLacknum() - 1);
            departmentService.editByPrimaryKeySelective(oneDepartmentById1);
        }
        position.setPositionLacknum(onePositionById.getPositionTotal() - position.getPositionExitsnum());
        boolean b = positionService.editByPrimaryKeySelective(position);
        return b;
    }

    @RequestMapping(value = "addPosition.position",method = RequestMethod.POST)
    @ResponseBody
    public boolean addPosition(Position position){
        Department oneDepartmentById = departmentService.getOneDepartmentById(position.getPositionDepartmentId());
        oneDepartmentById.setDepartmentExitsnum(oneDepartmentById.getDepartmentExitsnum()+1);
        oneDepartmentById.setDepartmentLacknum(oneDepartmentById.getDepartmentLacknum()-1);
        departmentService.editByPrimaryKeySelective(oneDepartmentById);
        position.setPositionLacknum(position.getPositionTotal()-position.getPositionExitsnum());
        boolean b = positionService.addPosition(position);
        return b;
    }
}
