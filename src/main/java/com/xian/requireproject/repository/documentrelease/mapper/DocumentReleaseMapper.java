package com.xian.requireproject.repository.documentrelease.mapper;


import com.xian.requireproject.repository.documentrelease.entity.DocumentReleaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DocumentReleaseMapper {
@Select("select*from require_document_release r where r.uuid=#{uuid}")
    List<DocumentReleaseEntity> getDocumentReleaseList(@Param("uuid") String uuid);
@Select("select*from require_document_release r where r.uuid=#{uuid}")
    DocumentReleaseEntity getDocumentReleaseInfo(@Param("uuid") String uuid);

}

