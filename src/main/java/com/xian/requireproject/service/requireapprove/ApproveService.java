package com.xian.requireproject.service.requireapprove;

import com.xian.requireproject.repository.requireapprove.entity.ApproveEntity;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.requireapprove.request.ApproveRequest;

import java.util.List;
import java.util.Map;

public interface ApproveService {
    void approveCommit(Map<String, Object> param);

    void updApprove(ApproveRequest approveRequest);

    void delApprove(String uuid);

    List<RequireRequest> getApproveList(Map<String, Object> paramMap);

    RequireRequest getApproveInfo(String uuid);

}
