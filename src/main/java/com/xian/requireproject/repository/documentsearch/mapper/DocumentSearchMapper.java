package com.xian.requireproject.repository.documentsearch.mapper;

import com.xian.requireproject.repository.documentsearch.entity.DocumentSearchEntity;
import com.xian.requireproject.repository.documentsearch.privider.DocumentSearchProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface DocumentSearchMapper {


    @SelectProvider(method = "getDocumentSearchList", type = DocumentSearchProvider.class)
    List<Map<String, Object>> getDocumentSearchList(Map<String, Object> param);


    //浏览(字段未知)

    @Select("SELECT `uuid`,`number`,`title`,`status`,`person`,`priority`,`require_type`,`function_description`,`create_time`,`remark`," +
            " FROM require_assistant_analysis  WHERE uuid = #{uuid}")
    DocumentSearchEntity getDocumentInfo(@Param("uuid") String uuid);

}
