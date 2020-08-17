package com.honger1234.springbootprojectseed.service;

import com.honger1234.springbootprojectseed.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;
import com.honger1234.springbootprojectseed.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 联系人表 服务类
 * </p>
 *
 * @author zt
 * @since 2020-08-17
 */
public interface IContactService extends IService<Contact> {
    /**
     * 获取当前用户的所有联系人
     * @param user
     * @return
     */
    List<Contact> loadAll(SysUser user);
}
