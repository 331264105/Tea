package com.didu.serviceImpl;

import com.didu.dao.ImageDao;
import com.didu.dao.TeaTypeDao;
import com.didu.domain.Tea;
import com.didu.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
@Transactional
public class TeaServiceImpl implements TeaService {
    @Autowired
    private TeaTypeDao teaTypeDao;
    @Override
    public boolean addImage(Tea teaType) {
        return teaTypeDao.addImage(teaType)>0?true:false;
    }

}
