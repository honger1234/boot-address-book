package com.honger1234.springbootprojectseed.service.impl;

import com.honger1234.springbootprojectseed.entity.Contact;
import com.honger1234.springbootprojectseed.dao.IContactDao;
import com.honger1234.springbootprojectseed.service.IContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 联系人表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2020-08-17
 */
@Service
public class ContactServiceImpl extends ServiceImpl<IContactDao, Contact> implements IContactService {

}
