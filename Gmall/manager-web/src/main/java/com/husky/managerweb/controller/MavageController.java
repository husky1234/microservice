package com.husky.managerweb.controller;

import com.husky.managerweb.entity.BaseAttrInfo;
import com.husky.managerweb.entity.BaseCatalog1;
import com.husky.managerweb.entity.BaseCatalog2;
import com.husky.managerweb.entity.BaseCatalog3;
import com.husky.managerweb.server.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MavageController {
    @Autowired
    ManageService manageService;

    @RequestMapping(value = "getCatalog1",method = RequestMethod.GET)
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }
    @RequestMapping(value = "getCatalog2/{id}",method = RequestMethod.GET)
    public List<BaseCatalog2> getCatalog2(@PathVariable(name = "id") Long id){
        return manageService.getCatalog2(id);
    }
    @RequestMapping(value = "getCatalog3/{id}",method = RequestMethod.GET)
    public List<BaseCatalog3> getCatalog3(@PathVariable(name = "id") Long id){
        return manageService.getCatalog3(id);
    }
    @RequestMapping(value = "attrInfoList/{id}",method = RequestMethod.GET)
    public List<BaseAttrInfo> attrList(@PathVariable(name = "id") Long id){
        return manageService.getAttrList(id);
    }
    @RequestMapping(value = "saveAttr",method = RequestMethod.PUT)
    public String saveAttr(@RequestBody BaseAttrInfo baseAttrInfo){
        return manageService.savaAttr(baseAttrInfo);
    }
    @RequestMapping(value = "updateAttr",method = RequestMethod.POST)
    public int updateAttr(@RequestBody BaseAttrInfo baseAttrInfo){
        return manageService.updateAttr(baseAttrInfo.getAttrName(),baseAttrInfo.getId());
    }

}
