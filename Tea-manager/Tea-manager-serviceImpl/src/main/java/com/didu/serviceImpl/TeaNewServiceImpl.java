package com.didu.serviceImpl;

import com.didu.dao.TeaNewDao;
import com.didu.domain.TeaNew;
import com.didu.service.TeaNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
@Service
@Transactional
public class TeaNewServiceImpl implements TeaNewService {
    @Autowired
    private TeaNewDao teaNewDao;

    @Override
    public boolean addTeaNew(TeaNew teaNew) {
        return teaNewDao.addTeaNew(teaNew)>0?true:false;
    }

    @Override
    public TeaNew selectTeaNew(int id) {
        return teaNewDao.selectTeaNew(id);
    }

    @Override
    public boolean removeTeaNew(int id) {
        return teaNewDao.removeTeaNew(id)>0?true:false;
    }

    @Override
    public boolean updateTeaNew(TeaNew teaNew) {
        return teaNewDao.updateTeaNew(teaNew)>0?true:false;
    }

    @Override
    public List<TeaNew> selectTeaNews() {
        return teaNewDao.selectTeaNews();
    }
}
