package com.xian.requireproject.repository.cangku.mapper;

import com.xian.requireproject.repository.cangku.entity.CangKu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CangKuMapper {
    List<CangKu> getAll();
    void addCang(CangKu cangKu);
    void updateCang(CangKu cangKu);
    void delCang(String uuid);
}
