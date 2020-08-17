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
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    @ApiOperation(value = "用户的所有联系人")
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

    /**
     * 添加联系人
     * @param contact
     * @return
     */
    @PostMapping(value = "/add")
    @ApiOperation(value = "添加联系人")
    public Result addContact(@RequestBody Contact contact){
        boolean save = contactService.save(contact);
        if (save){
            return ResultGenerator.genSuccessResult(contact);
        }
        return ResultGenerator.genFailResult("添加失败");
    }

    @GetMapping(value = "/detail")
    @ApiOperation(value = "联系人详情")
    public Result contactDetail(@RequestParam Integer id){
        if (id==null){
            return ResultGenerator.genFailResult("联系人ID不能为空");
        }
        Contact contact = contactService.getById(id);
        if (contact==null){
            return ResultGenerator.genFailResult("联系人不存在");
        }
        return ResultGenerator.genSuccessResult(contact);
    }

    /**
     * 更新联系人信息
     * @param contact
     * @return
     */
    @PostMapping(value = "/update")
    @ApiOperation(value = "修改联系人")
    public Result updateContact(@RequestBody Contact contact){
        boolean b = contactService.updateById(contact);
        if (b){
            return ResultGenerator.genSuccessResult(contact);
        }
        return ResultGenerator.genFailResult("更新失败");
    }

    /**
     * 删除联系人
     * @param contact
     * @return
     */
    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除联系人")
    public Result delete(@RequestBody Contact contact){
        boolean b = contactService.removeById(contact);
        if (b){
            return ResultGenerator.genSuccessResult(contact);
        }
        return ResultGenerator.genFailResult("删除失败");
    }

}

