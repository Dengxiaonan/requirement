package com.xian.requireproject.service.requireapplicant;

import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
import com.xian.requireproject.repository.requireapplicant.entity.MilitaryZone;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;

import java.util.List;

public interface RequireService {
    void addRequire(RequireRequest requireRequest);

    void updRequire(RequireRequest requireRequest);

    void delRequire(String uuid);

    RequireRequest getRequireInfo(String uuid);

    //获取需求申请信息列表
    List<RequireRequest> getRequireList(RequireRequest requireRequest);
    //获取需求审批信息列表
    Object getApproveList(RequireRequest requireRequest);
    //获取需求辅助分析信息列表
    Object getAssistList(RequireRequest requireRequest);
    //获取需求文档发布信息列表
    Object getDocumentList(RequireRequest requireRequest);
    //需求提交
    void submitDemand(RequireRequest requireRequest);
    //需求审批
    void demandExamine(RequireRequest requireRequest);
    //需求退回
    void demandExamines(RequireRequest requireRequest);
    //需求评论
    void addComment(CommentEntity commentEntity);
    //查询需求评论
    List<CommentEntity> queryComment(String rid);

    List<MilitaryZone> getZone();


    List<SysUserEntity> getZoneUser(String userId);

}
