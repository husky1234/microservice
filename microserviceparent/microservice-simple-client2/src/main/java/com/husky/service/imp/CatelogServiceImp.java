package com.husky.service.imp;

import com.husky.jopo.BaseCatolog1;
import com.husky.reposity.CatelogReposity;
import com.husky.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatelogServiceImp implements CatelogService {

    @Autowired
    CatelogReposity catelogReposity;
    @Override
    public BaseCatolog1 getCatologInfo(int id) {
        return catelogReposity.findById(id);
    }
}
