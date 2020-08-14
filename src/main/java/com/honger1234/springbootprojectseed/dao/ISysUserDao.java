package com.honger1234.springbootprojectseed.dao;

import com.honger1234.springbootprojectseed.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2020-08-13
 */
//@Mapper
public interface ISysUserDao extends BaseMapper<SysUser> {
    /**
     * 根据用户名查询账号
     * @param username
     * @return
     */
    SysUser listByUsername(String username);
}
