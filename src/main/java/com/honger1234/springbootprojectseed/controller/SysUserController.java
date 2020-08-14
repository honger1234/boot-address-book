package com.honger1234.springbootprojectseed.controller;


import com.alibaba.fastjson.JSON;
import com.honger1234.springbootprojectseed.entity.SysUser;
import com.honger1234.springbootprojectseed.service.ISysUserService;
import com.honger1234.springbootprojectseed.util.JWTUtil;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
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
@Api(tags = "系统用户模块")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public Object login(@RequestBody SysUser user){
        // 将 实体类 转换为 Map
//        Map map = JSON.parseObject(JSON.toJSONString(user), Map.class);
        SysUser sysUser=sysUserService.listByUsername(user.getUsername());
//        List<SysUser> list = sysUserService.listByMap(map);
        if (sysUser==null){
            return ResultGenerator.genFailResult("登陆失败，用户名或密码错误");
        }
        //生成token
        String token= JWTUtil.generate(sysUser.getId().toString(),sysUser.getUsername());
//        Claims claim = JWTUtil.getClaim(token);
        return ResultGenerator.genSuccessResult(token);
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册")
    public Object register(@RequestBody SysUser user){
        boolean save = sysUserService.save(user);
        if (save){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("注册失败");
    }

}

