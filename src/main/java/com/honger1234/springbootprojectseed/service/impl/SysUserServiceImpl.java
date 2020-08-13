package com.honger1234.springbootprojectseed.service.impl;

import com.honger1234.springbootprojectseed.entity.SysUser;
import com.honger1234.springbootprojectseed.dao.ISysUserDao;
import com.honger1234.springbootprojectseed.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2020-08-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<ISysUserDao, SysUser> implements ISysUserService {

}
