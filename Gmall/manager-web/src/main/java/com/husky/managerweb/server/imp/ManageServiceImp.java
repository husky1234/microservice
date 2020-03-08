package com.husky.managerweb.server.imp;

import com.husky.managerweb.entity.BaseAttrInfo;
import com.husky.managerweb.entity.BaseCatalog1;
import com.husky.managerweb.entity.BaseCatalog2;
import com.husky.managerweb.entity.BaseCatalog3;
import com.husky.managerweb.reposity.*;
import com.husky.managerweb.server.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManageServiceImp implements ManageService {

    @Autowired
    BaseCatalog1Reposity baseCatalog1Reposity;
    @Autowired
    BaseCatalog2Reposity baseCatalog2Reposity;
    @Autowired
    BaseCatalog3Reposity baseCatalog3Reposity;
    @Autowired
    BaseAttrInfoReposity baseAttrInfoReposity;
    @Autowired
    BaseAttrValueReposity baseAttrValueReposity;
    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Reposity.findAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2(Long catalog1Id) {
        return baseCatalog2Reposity.findByCatalog1Id(catalog1Id);
    }

    @Override
    public List<BaseCatalog3> getCatalog3(Long catalog2Id) {
        return baseCatalog3Reposity.findByCatalog2Id(catalog2Id);
    }

    @Override
    public List<BaseAttrInfo> getAttrList(Long catalog3Id) {
        return baseAttrInfoReposity.findByCatalog3Id(catalog3Id);
    }

    @Override
    public String savaAttr(BaseAttrInfo baseAttrInfo) {
        BaseAttrInfo info = baseAttrInfoReposity.save(baseAttrInfo);
        if (info != null){
            return "success!";
        }
        return "false!";
    }

    @Override
    public int updateAttr(String attrName, Long id) {
        return baseAttrInfoReposity.updateAttr(attrName,id);
    }

}
