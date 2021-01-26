package com.xian.requireproject.service.requireapplicant.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xian.requireproject.common.MapperUtils;
import com.xian.requireproject.common.UUIDUtils;
import com.xian.requireproject.common.UseDetailsDTO;
import com.xian.requireproject.common.UserUtil;
import com.xian.requireproject.common.redis.RedisUtil;
import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
//import com.xian.requireproject.repository.requireapplicant.entity.MilitaryZone;
import com.xian.requireproject.repository.requireapplicant.entity.MilitaryZone;
import com.xian.requireproject.repository.requireapplicant.entity.RequireEntity;
import com.xian.requireproject.repository.requireapplicant.mapper.RequireMapper;
import com.xian.requireproject.repository.sysuser.entity.SysUserEntity;
import com.xian.requireproject.service.requireapplicant.RequireService;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class RequireServiceImpl implements RequireService {

    @Resource
    RequireMapper requireMapper;

    @Resource
    RedisUtil redisUtil;
    @Autowired
    private HttpServletRequest request;
    //添加信息
    @Override
    public void addRequire(RequireRequest requireRequest) {

        requireRequest.setUuid(UUIDUtils.getUUID());

        requireMapper.addRequire(requireRequest);

    }
    //修改信息
    @Override
    public void updRequire(RequireRequest requireRequest) {

        RequireEntity requireEntity = MapperUtils.mapperBean(requireRequest, RequireEntity.class);

        requireMapper.updRequire(requireEntity);
    }
    //根据编号删除数据
    @Override
    public void delRequire(String uuid) {
        requireMapper.delRequire(uuid);

    }

    //根据编号获取信息
    @Override
    public RequireRequest getRequireInfo(String uuid) {

        return requireMapper.getRequireInfo(uuid);
    }
//需求申请
    @Override
    public List<RequireRequest> getRequireList(RequireRequest requireRequest) {
        return requireMapper.getRequireList(requireRequest);
    }
//需求审批
   @Override
    public Object getApproveList(RequireRequest requireRequest) {
        PageHelper.startPage(requireRequest.getPageNo(), requireRequest.getPageSize());
        PageInfo<RequireRequest> pageInfo = new PageInfo(requireMapper.getApproveList(requireRequest));
        return pageInfo;
    }
//需求辅助分析
    @Override
    public Object getAssistList(RequireRequest requireRequest) {
        PageHelper.startPage(requireRequest.getPageNo(), requireRequest.getPageSize());
        PageInfo<RequireRequest> pageInfo = new PageInfo(requireMapper.getAssistList(requireRequest));
        return pageInfo;
    }
//需求文档发布
    @Override
    public Object getDocumentList(RequireRequest requireRequest) {
        PageHelper.startPage(requireRequest.getPageNo(), requireRequest.getPageSize());
        PageInfo<RequireRequest> pageInfo = new PageInfo(requireMapper.getDocumentList(requireRequest));
        return pageInfo;
    }
//需求提交
    @Override
    public void submitDemand(RequireRequest requireRequest) {
        requireMapper.submitDemand(requireRequest);
    }
//需求审批
    @Override
    public void demandExamine(RequireRequest requireRequest) {
        requireMapper.demandExamine( requireRequest);
    }
//需求审批
    @Override
    public void demandExamines(RequireRequest requireRequest) {
        requireMapper.demandExamines( requireRequest);
    }
//添加评论
    @Override
    public void addComment(CommentEntity commentEntity) {
        requireMapper.addComment(commentEntity);
    }
//查询评论
    @Override
    public List<CommentEntity> queryComment(String rid) {
        return requireMapper.queryComment(rid);
    }

    @Override
    public List<MilitaryZone> getZone(){
        requireMapper.getZone();
        return null;
    }

    @Override
    public List<SysUserEntity> getZoneUser(String userId){
        requireMapper.getZoneUser(userId);
        return null;
    }


}
