package com.xian.requireproject.service.cangku.Impl;

import com.xian.requireproject.repository.cangku.entity.CangKu;
import com.xian.requireproject.repository.cangku.mapper.CangKuMapper;
import com.xian.requireproject.service.cangku.CangKuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CangKuServiceImpl implements CangKuService {
    @Resource
    private  CangKuMapper cangKuMapper;

    @Override
    public List<CangKu> getAll() {
        return cangKuMapper.getAll();
    }

    @Override
    public void addCang(CangKu cangKu) {
     cangKuMapper.addCang(cangKu);
    }

    @Override
    public void updateCang(CangKu cangKu) {
    cangKuMapper.updateCang(cangKu);
    }

    @Override
    public void delCang(String uuid) {
     cangKuMapper.delCang(uuid);
    }
}
