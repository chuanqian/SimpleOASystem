package com.zaqacu.service.impl;

import com.zaqacu.dao.PayMapper;
import com.zaqacu.entity.Pay;
import com.zaqacu.entitydto.PayDto;
import com.zaqacu.service.*;
import com.zaqacu.util.GetFristAndLastDaUtils;
import com.zaqacu.util.TimeUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private CheckService checkService;
    @Autowired
    private BasicMoneyService basicMoneyService;
    @Autowired
    private MertisMoneyService mertisMoneyService;
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private StaffService staffService;

    @Override
    public boolean addPay(String staffUid, String StaffName, String payBasicId, String payMertisId, String payTime) {
        Pay pay = new Pay();
        pay.setPayBasicId(Integer.parseInt(payBasicId.trim()));
        pay.setPayMertisId(Integer.parseInt(payMertisId.trim()));
        Date firstDay = GetFristAndLastDaUtils.getFirstDay(TimeUtls.getTimeFommat(new Date()));
        List<Double> checkByStaffUidAndDates = checkService.getAllCheckByStaffUidAndDate(staffUid, firstDay, new Date());
        double reword = 0;
        double fine = 0;
        if (checkByStaffUidAndDates != null) {
            if (checkByStaffUidAndDates.size() != 0) {
                for (Double money : checkByStaffUidAndDates) {
                    if (money > 0) {
                        reword += money;
                    } else {
                        fine += money;
                    }
                }
            }
        }
        pay.setPayFine(fine);
        pay.setPayRewords(reword);
        double basicMoney = basicMoneyService.getOneBasicMoneyById(Integer.parseInt(payBasicId.trim()));
        double mertisMoney = mertisMoneyService.getOneMertisById(Integer.parseInt(payMertisId.trim()));
        double total = basicMoney + mertisMoney + reword + fine;
        pay.setPayTotal(total);
        pay.setPayTime(TimeUtls.getTimeParse(payTime));
        pay.setPayStaffUid(staffUid);
        return payMapper.insertSelective(pay) != 0 ? true : false;
    }

    @Override
    public HashMap<String, Object> getPayBySql(Pay pay) {
        pay.setStart((pay.getPage() - 1) * pay.getRows());
        List<Pay> payList = payMapper.selectPayBySql(pay);
        List<PayDto> payDtos = new ArrayList<>();
        for (Pay pay1 : payList) {
            PayDto payDto = new PayDto();
            payDto.setPayTime(pay1.getPayTime());
            payDto.setPayFine(pay1.getPayFine());
            payDto.setPayRewords(pay1.getPayRewords());
            payDto.setPayId(pay1.getPayId());
            payDto.setPayTotal(pay1.getPayTotal());
            payDto.setStaff(staffService.getOneStaffByUid(pay1.getPayStaffUid()));
            payDto.setBasicMoney(basicMoneyService.getByPrimaryKey(pay1.getPayBasicId()));
            payDto.setMertisMoney(mertisMoneyService.getByPrimaryKey(pay1.getPayMertisId()));
            payDtos.add(payDto);
        }
        int total = payMapper.selectAllPayCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", payDtos);
        return map;
    }

    @Override
    public boolean removePayByIds(String ids) {
        String[] idss = ids.split(",");
        List<Integer> payIds = new ArrayList<>();
        for (String s : idss) {
            payIds.add(Integer.parseInt(s.trim()));
        }
        return payMapper.deleteByPayIds(payIds) != 0 ? true : false;
    }
}
