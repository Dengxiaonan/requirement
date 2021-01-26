package com.xian.requireproject.service.cangku;

import com.xian.requireproject.repository.cangku.entity.CangKu;


import java.util.List;

public interface CangKuService {
    List<CangKu> getAll();
    void addCang(CangKu cangKu);
    void updateCang(CangKu cangKu);
    void  delCang(String uuuid);
}
