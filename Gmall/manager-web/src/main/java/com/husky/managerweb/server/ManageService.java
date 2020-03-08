package com.husky.managerweb.server;

import com.husky.managerweb.entity.BaseAttrInfo;
import com.husky.managerweb.entity.BaseCatalog1;
import com.husky.managerweb.entity.BaseCatalog2;
import com.husky.managerweb.entity.BaseCatalog3;

import java.util.List;

public interface ManageService {
    List<BaseCatalog1> getCatalog1();
    List<BaseCatalog2> getCatalog2(Long catalog1Id);
    List<BaseCatalog3> getCatalog3(Long catalog2Id);
    List<BaseAttrInfo> getAttrList(Long catalog3Id);

    String savaAttr(BaseAttrInfo baseAttrInfo);

    int updateAttr(String attrName, Long id);
}
