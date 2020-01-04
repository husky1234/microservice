package com.husky.controller;

import com.husky.jopo.BaseCatolog1;
import com.husky.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catelog")
public class CatelogController {
    @Autowired
    CatelogService catelogService;

    @RequestMapping("/oneInfo/{id}")
    public BaseCatolog1 getCatelogInfo(@PathVariable(value = "id") int id){
        return catelogService.getCatologInfo(id);
    }
}
