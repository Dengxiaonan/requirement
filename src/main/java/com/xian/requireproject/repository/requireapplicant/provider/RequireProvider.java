package com.xian.requireproject.repository.requireapplicant.provider;

import com.xian.requireproject.repository.requireapplicant.entity.CommentEntity;
import com.xian.requireproject.service.documentsearch.request.DocumentsearchRequest;
import com.xian.requireproject.service.logManagement.request.LogRequest;
import com.xian.requireproject.service.requireapplicant.request.RequireRequest;
import com.xian.requireproject.service.researchmodule.request.ResearchRequest;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class RequireProvider extends SQL {

    /**
     * ######需求申请全查########
     * 查询状态状态现在不明确明确以后可以根据页面需求进行修改
     * 0为待审批1同意2拒绝3退回待发布5收集6评审7发布
     * ra.status IN (5,6,7)
     *
     * **/

    public String getRequireList(RequireRequest requireRequest) {
        String s = new SQL() {{
            SELECT("ra.uuid,ra.number,ra.project_name,ra.status,ra.subject_term,ra.person,ra.priority,ra.require_type,ra.fun_desc,ra.create_time ,ra.remark  , ra.import_type");
            FROM("require_applicant  ra");
            //if (requireRequest.getStatus() == null){
                WHERE("ra.status in (0, 3, 4)");//状态0未提交1待审批2已审批(已发布)3已退回4拒绝
            //}
            if (!StringUtils.isEmpty(requireRequest.getNumber())) {
                WHERE("ra.number LIKE CONCAT('%', #{number}, '%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getSubjectTerm())) {
                WHERE("ra.subject_term LIKE CONCAT('%', #{subjectTerm}, '%')");
            }
//            if (!StringUtils.isEmpty(requireRequest.getPerson())) {
//                WHERE("ra.person LIKE CONCAT('%', #{person}, '%')");
//            }
//            if (null != requireRequest.getStatus()) {
//                WHERE("ra.status = #{status}" );
//            }
            if (null != requireRequest.getStatuss()) {
                WHERE("ra.statuss = #{statuss}" );
            }
        }}.toString();
        System.out.println(s);
        return s;
    }
    /**
     * ######需求审批全查########
     * 查询状态状态现在不明确明确以后可以根据页面需求进行修改
     * 0为待审批1同意2拒绝3退回待发布5收集6评审7发布
     * ra.status IN (5,6,7)
     *
     * **/
    public String getApproveList(RequireRequest requireRequest) {
        String s = new SQL() {{
            SELECT("ra.uuid,ra.number,ra.subject_term,ra.status,ra.person,ra.priority,ra.require_type,ra.fun_desc,ra.create_time ,ra.remark");
            FROM("require_applicant  ra");
            if (requireRequest.getStatus()==null){
            WHERE("ra.status IN (0)");}
            if (!StringUtils.isEmpty(requireRequest.getNumber())) {
                WHERE("ra.number LIKE concat'%'#{number}'%'");
            }
            if (!StringUtils.isEmpty(requireRequest.getSubjectTerm())) {
                WHERE("ra.subject_term LIKE concat'%'#{subjectTerm}'%'");
            }
            if (!StringUtils.isEmpty(requireRequest.getPerson())) {
                WHERE("ra.person LIKE concat'%'#{person}'%'");
            }
            if (requireRequest.getStatus() != null) {
                WHERE("ra.status = #{status}" );
            }
            if (requireRequest.getStatuss()!= null) {
                WHERE("ra.statuss = #{statuss}" );
            }

        }}.toString();
        System.out.println(s);
        return s;
    }

    /**
     * ######需求辅助分析全查########
     * 查询状态状态现在不明确明确以后可以根据页面需求进行修改
     * 0为待审批1同意2拒绝3退回待发布5收集6评审7发布
     * ra.status IN (5,6,7)
     *不知道关键词是那个现在没写模糊查询
     * **/
    public String getAssistList(RequireRequest requireRequest) {
        String s = new SQL() {{
            SELECT("ra.uuid,ra.number,ra.project_name,ra.status,ra.subject_term,ra.person,ra.priority,ra.require_type,ra.fun_desc,ra.create_time,ra.remark,ra.import_type,ra.require_ref_cause,ra.examine,ra.statuss");
            FROM("require_applicant  ra");
//            if (requireRequest.getStatus()==null){
//                WHERE("ra.status IN (0)");}
            if (!StringUtils.isEmpty(requireRequest.getProjectName())) {
                WHERE("ra.project_name LIKE concat('%',#{ProjectName},'%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getSubjectTerm())) {
                WHERE("ra.subject_term LIKE concat('%',#{subjectTerm},'%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getPerson())) {
                WHERE("ra.person LIKE concat('%',#{person},'%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getRequireType())) {
                WHERE("ra.require_type LIKE concat('%',#{require_type},'%')");
            }

            if (requireRequest.getStatus()!=null) {
                WHERE("ra.status = #{status}");
            }

        }}.toString();
        System.out.println(s);
        return s;
    }
    /**
     * ######需求文档发布全查########
     * 查询状态状态现在不明确明确以后可以根据页面需求进行修改
     * 0为待审批1同意2拒绝3退回待发布5收集6评审7发布
     * ra.status IN (5,6,7)
     *不知道主题词是哪个现在没写模糊查询
     * **/
    public String getDocumentList(RequireRequest requireRequest) {
        String s = new SQL() {{
            SELECT("ra.uuid,ra.number,ra.project_name,ra.status,ra.subject_term,ra.person,ra.priority,ra.require_type,ra.fun_desc,ra.create_time ,ra.remark, ra.import_type");
            FROM("require_applicant  ra");
            if (requireRequest.getStatus()==null){
                WHERE("ra.status IN (0)");}
            if (!StringUtils.isEmpty(requireRequest.getNumber())) {
                WHERE("ra.number LIKE concat'%'#{number}'%'");
            }
            if (!StringUtils.isEmpty(requireRequest.getSubjectTerm())) {
                WHERE("ra.subject_term LIKE concat'%'#{subjectTerm}'%'");
            }
            if (!StringUtils.isEmpty(requireRequest.getPerson())) {
                WHERE("ra.person LIKE concat'%'#{person}'%'");
            }
            if (requireRequest.getStatus()!=null) {
                WHERE("ra.status = #{status}");
            }

        }}.toString();
        System.out.println(s);
        return s;
    }
    /**
     * 文档搜索
     */
    public String getDocumentSearchList(DocumentsearchRequest documentsearchRequest){
        String s = new SQL(){{
            SELECT("ds.uuid,ds.number,ds.project_name,ds.file_name,ds.start_time,ds.end_time,ds.document_name,ds.type,ds.keyword,ds.issuer,ds.detailed_information,ds.remark");
            FROM("document_search  ds");
            if (!StringUtils.isEmpty(documentsearchRequest.getNumber())) {
                WHERE("ds.number LIKE concat'%'#{number}'%'");
            }
            if (!StringUtils.isEmpty(documentsearchRequest.getProjectName())) {
                WHERE("ds.project_name LIKE concat'%'#{projectName}'%'");
            }
            if (!StringUtils.isEmpty(documentsearchRequest.getFilename())) {
                WHERE("ds.file_name LIKE concat'%'#{fileName}'%'");
            }
            if (!StringUtils.isEmpty(documentsearchRequest.getIssuer())) {
                WHERE("ds.issuer LIKE concat'%'#{issuer}'%'");
            }

        }}.toString();
        System.out.println(s);
        return s;
    }
/**
 * 研发组件管理
 */
   public String getResearchList(ResearchRequest researchRequest){
      String s = new SQL(){{
        SELECT("ds.uuid,ds.number,ds.module_name,ds.module_version,ds.keyword,ds.issuer,ds.subject_terms,ds.project_name,ds.status,ds.priority,ds.person,ds.create_time,ds.operation");
        FROM("require_research_module  ds");
        if (!StringUtils.isEmpty(researchRequest.getNumber())) {
            WHERE("ds.number LIKE concat'%'#{number}'%'");
        }
        if (!StringUtils.isEmpty(researchRequest.getKeyword())) {
            WHERE("ds.keyword LIKE concat'%'#{keyword}'%'");
        }
        if (!StringUtils.isEmpty(researchRequest.getIssuer())) {
            WHERE("ds.issuer LIKE concat'%'#{issuer}'%'");
        }

    }}.toString();
    System.out.println(s);
    return s;
}
/**
 * 日志管理
 */
public String getLogList(LogRequest logRequest) {
    String s = new SQL() {{
        SELECT("lm.uuid,lm.operation_time,lm.login_name,lm.operation,lm.ip,lm.describe,lm.details");
        FROM("log_management lm");
        if (!StringUtils.isEmpty(logRequest.getLoginName())) {
            WHERE("lm.system_module LIKE concat'%'#{systemModule}'%'");
        }
        if (!StringUtils.isEmpty(logRequest.getOperation())) {
            WHERE("lm.operator LIKE concat'%'#{operator}'%'");
        }
        if (!StringUtils.isEmpty(logRequest.getIp())) {
            WHERE("lm.operation_type LIKE concat'%'#{operationType}");
        }
        if (!StringUtils.isEmpty(logRequest.getDescribe())) {
            WHERE("lm.operation_status LIKE concat'%'#{operationStatus}");
        }
        if (!StringUtils.isEmpty(logRequest.getDetails())) {
            WHERE("lm.operation_date LIKE concat'%'#{operationDate}");
        }
    }}.toString();
    System.out.println(s);
    return s;
}








    /**
     *
     * 需求提交
     */
    public String submitDemand(RequireRequest requireRequest){
        String s = new SQL(){{
            UPDATE("require_applicant SET status = 1");
            WHERE("uuid = #{uuid}");
        }}.toString();
        System.out.println(s);
        return s;
    }

    /***
     * 需求审批
     */
    public String demandExamine(RequireRequest requireRequest){
        String s = new  SQL(){{
            UPDATE(" require_approve SET `status` = #{status} ");
            WHERE(" `uuid` = #{uuid} ");
        }}.toString();
        return s;
    }
    /***
     * 需求审批
     */
    public String demandExamines(RequireRequest requireRequest){
        String s = new  SQL(){{
            UPDATE(" require_approve SET `status` = #{status} , `cause` = #{cause} ");
            WHERE(" `uuid` = #{uuid} ");
        }}.toString();
        return s;
    }
    /****
     * 需求评论
     */
    public String addComment(CommentEntity commentEntity){
        String sql = new SQL(){{
       INSERT_INTO("demand_comments");
       VALUES("id","#{id}");
       VALUES("commentator","#{commentator}");
       VALUES("edit_time","#{editTime}");
       VALUES("content","#{content}");
       VALUES("r_id","#{rid}");
        }}.toString();
        System.out.println(sql);
        return sql;
    }

    /****
     * 需求评论查询
     */
    public String queryComment(String rid){
        String sql = new SQL(){{
            SELECT("a.id, b.nick_name, a.commentator, a.edit_time, a.content, a.r_id");
            FROM("demand_comments a");
            FROM("sys_user b");
            WHERE("a.commentator = b.uuid");
            WHERE("r_id = #{rid}");
            ORDER_BY("a.edit_time DESC ");
        }}.toString();
        System.out.println(sql);
        return sql;
    }
    /*****
     * 过程管理条件查询

     */
    public String getProcess(RequireRequest requireRequest) {
        String sql = new SQL() {{
            SELECT("ra.uuid,\n" +
                    "ra.number,\n" +
                    "ra.project_name,\n" +
                    "ra.status,\n" +
                    "ra.subject_term,\n" +
                    "ra.person,\n" +
                    "ra.priority,\n" +
                    "ra.require_type,\n" +
                    "ra.fun_desc,\n" +
                    "ra.create_time,\n" +
                    "ra.remark,\n" +
                    "ra.import_type");
            FROM("require_applicant  ra");
            //if (requireRequest.getStatus() == null){
            WHERE("ra.status in (0 , 1 , 2)");//状态0未提交1待审批2已审批(已发布)3已退回4拒绝
            //}
            if (!StringUtils.isEmpty(requireRequest.getRequireType())) {
                WHERE("ra.require_type LIKE CONCAT('%', #{requireType}, '%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getSubjectTerm())) {
                WHERE("ra.require_type LIKE CONCAT('%', #{subjectTerm}, '%')");
            }
            if (!StringUtils.isEmpty(requireRequest.getPerson())) {
                WHERE("ra.require_type LIKE CONCAT('%', #{person}, '%')");
            }
        }}.toString();
        return sql;
    }
}