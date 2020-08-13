package com.honger1234.springbootprojectseed.controller;


import com.alibaba.fastjson.JSON;
import com.honger1234.springbootprojectseed.entity.SysUser;
import com.honger1234.springbootprojectseed.service.ISysUserService;
import com.honger1234.springbootprojectseed.util.JWTUtil;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author zt
 */
@RestController
@RequestMapping(value = "sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public Object login(@RequestBody SysUser user){
        // 将 实体类 转换为 Map
        Map map = JSON.parseObject(JSON.toJSONString(user), Map.class);
        List<SysUser> list = sysUserService.listByMap(map);
        if (CollectionUtils.isEmpty(list)){
            return ResultGenerator.genFailResult("登陆失败，用户名或密码错误");
        }
        //生成token
        String token= JWTUtil.generate(list.get(0).getId().toString(),user.getUsername());
        Claims claim = JWTUtil.getClaim(token);
        return ResultGenerator.genSuccessResult(token);
    }

}

