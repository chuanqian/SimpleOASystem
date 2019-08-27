package com.zaqacu.service;

import java.util.List;

public interface CheckStaffStatusService {
    boolean addCheckStaffStatusByStaffUid(String staffUid);

    boolean removeBatchByStaffUid(List<String> staffUidList);
}
