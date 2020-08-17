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
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.toJSON(user).toString());
//        List<Contact> contacts=contactService.loadAll(user);
        jsonObject.put("addressBook","这是通讯录的全部联系人");
        return ResultGenerator.genSuccessResult(jsonObject1);
    }

}

