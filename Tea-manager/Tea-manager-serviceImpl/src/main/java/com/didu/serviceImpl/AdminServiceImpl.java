package com.didu.serviceImpl;

import com.didu.dao.AdminDao;
import com.didu.domain.Admin;
import com.didu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/23.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
