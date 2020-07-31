package com.honger1234.springbootprojectseed.service.impl;

import com.honger1234.springbootprojectseed.entity.Employee;
import com.honger1234.springbootprojectseed.dao.IEmployeeDao;
import com.honger1234.springbootprojectseed.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zt
 * @since 2020-07-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<IEmployeeDao, Employee> implements IEmployeeService {

}
