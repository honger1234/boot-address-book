package com.honger1234.springbootprojectseed.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.honger1234.springbootprojectseed.annotation.CurrentUser;
import com.honger1234.springbootprojectseed.entity.Contact;
import com.honger1234.springbootprojectseed.entity.Result;
import com.honger1234.springbootprojectseed.entity.SysUser;
import com.honger1234.springbootprojectseed.service.IContactService;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 联系人表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/contact")
@Api(tags = "联系人模块")
public class ContactController {

    @Autowired
    private IContactService contactService;

    /**
     * 获取用户的所有联系人
     * @return
     */
    @GetMapping("/loadAll")
    @ApiOperation(value = "用户的所有联系人", notes = "获取用户的所有联系人")
    public Result<JSONObject> loadAll(@CurrentUser SysUser user){
//        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSON(user).toString());
        List<Contact> contacts=contactService.loadAll(user);
        //调整返回格式
        JSONObject jsonObject = new JSONObject();
        for (int i=0;i<contacts.size();i++){
            String initial=contacts.get(i).getInitial();
            //如果对象的字母和上一个的首字母相同，继续遍历
            if (i>0){
                String lastinitial=contacts.get(i-1).getInitial();
                if (lastinitial.equals(initial)){
                    continue;
                }
            }
            List<Contact> list=new ArrayList<>();//首字母对应的联系人
            jsonObject.put(initial,list);
            for (Contact contact:contacts){
                String newInitial=contact.getInitial();
                if (initial.equals(newInitial)){
                    list.add(contact);
                }
            }
        }
        return ResultGenerator.genSuccessResult(jsonObject);
    }

}

