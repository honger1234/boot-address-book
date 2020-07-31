package com.honger1234.springbootprojectseed.controller;

import com.honger1234.springbootprojectseed.util.JWTUtil;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zt
 * @date: 2020/7/28
 */
@RestController
@RequestMapping(value = "user")
@Api(tags = "用户模块",value = "用户模块value")
public class UserController {


    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public Object login(@ApiParam(name = "username",value = "用户名",required = true) @RequestParam(value = "username") String username, @ApiParam(name = "password",value = "密码",required = true) @RequestParam(value = "password") String password){
//        String username=user.getUsername();
//        String password=user.getPassword();
        Map<String,Object> map=new HashMap<>();
        if (username.equals("admin")&&password.equals("honger1234")){
            //生成token
            String token= JWTUtil.generate("222",username);
            Claims claim = JWTUtil.getClaim(token);
            return ResultGenerator.genSuccessResult(token);
        }
            return ResultGenerator.genFailResult("登陆失败，用户名或密码错误");
    }

    @ApiOperation(value = "token解析",notes = "token解析")
    @GetMapping(value = "/parseToken")
    public Object parseToken(HttpServletRequest request){
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            return ResultGenerator.genFailResult("token不能为空");
        }
        Claims claim = JWTUtil.getClaim(token);
        String subject = claim.getSubject();
        return ResultGenerator.genSuccessResult(claim);
    }

}
