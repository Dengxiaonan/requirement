package com.xian.requireproject.service.processManagement;


import com.xian.requireproject.service.requireapplicant.request.RequireRequest;

import java.util.List;

public interface ProcessManageService {
    List<RequireRequest> getProcess(RequireRequest requireRequest);
    RequireRequest getProcessInfo(String uuid);
    RequireRequest getQueryProcess(String uuid);
    void delProcess(String uuid);
}
