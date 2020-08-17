package com.honger1234.springbootprojectseed.dao;

import com.honger1234.springbootprojectseed.entity.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honger1234.springbootprojectseed.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 联系人表 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2020-08-17
 */
public interface IContactDao extends BaseMapper<Contact> {
    /**
     * 获取当前用户的所有联系人
     * @param user
     * @return
     */
    List<Contact> loadAll(SysUser user);
}
