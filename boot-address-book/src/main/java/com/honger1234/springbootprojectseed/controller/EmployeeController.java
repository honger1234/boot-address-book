package com.honger1234.springbootprojectseed.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honger1234.springbootprojectseed.dao.IEmployeeDao;
import com.honger1234.springbootprojectseed.entity.Employee;
import com.honger1234.springbootprojectseed.entity.Result;
import com.honger1234.springbootprojectseed.service.IEmployeeService;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zt
 * @since 2020-07-28
 */
@RestController
@RequestMapping("/employee")
@Api(tags = "员工模块")
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/list")
    public Result list(){
        Page<Employee> page=new Page<>(1,5);
        IPage<Employee> page2 = employeeService.page(page);
        return ResultGenerator.genSuccessResult(page2);
    }

}

