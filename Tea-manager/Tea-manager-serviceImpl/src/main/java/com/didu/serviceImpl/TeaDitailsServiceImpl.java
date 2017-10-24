package com.didu.serviceImpl;

import com.didu.dao.TeaDitailsDao;
import com.didu.domain.Tea;
import com.didu.domain.Tealist;
import com.didu.service.TeaDitailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
@Service
@Transactional
public class TeaDitailsServiceImpl implements TeaDitailsService{
   @Autowired
    private TeaDitailsDao teaDitailsDao;

    @Override
    public boolean addTeaDitails(Tealist tealist) {
        return teaDitailsDao.addTeaDitails(tealist);
    }

    @Override
    public boolean removeTeaDitails(int id) {
        return teaDitailsDao.removeTeaDitails(id)>0?true:false;
    }

    @Override
    public Tealist selectTeaDitails(int id) {
        return teaDitailsDao.selectTeaDitails(id);
    }

    @Override
    public boolean updateTeaDitails(Tealist tealist) {
        return teaDitailsDao.updateTeaDitails(tealist)>0?true:false;
    }

    @Override
    public List<Tea> selectTea() {
        return teaDitailsDao.selectTea();
    }

    @Override
    public List<Tealist> selectTealist(int cid) {
        return teaDitailsDao.selectTealist(cid);
    }

    @Override
    public int selectTeaId() {
        return teaDitailsDao.selectTeaId();
    }

}
