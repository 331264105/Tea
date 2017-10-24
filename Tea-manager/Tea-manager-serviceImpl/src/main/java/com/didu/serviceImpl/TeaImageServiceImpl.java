package com.didu.serviceImpl;

import com.didu.dao.TeaImageDao;
import com.didu.dao.TeaTypeDao;
import com.didu.domain.TeaImage;
import com.didu.service.TeaImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/17.
 */
@Service
@Transactional
public class TeaImageServiceImpl implements TeaImageService {
    @Autowired
    private TeaImageDao teaImageDao;
    @Override
    public boolean addTeaCarousel(TeaImage teaImage) {
        return teaImageDao.addTeaCarousel(teaImage)>0?true:false;
    }

    @Override
    public TeaImage selectTeaImage(int id) {
        return teaImageDao.selectTeaImage(id);
    }

    @Override
    public boolean removeTeaImage(int id) {
        return teaImageDao.removeTeaImage(id)>0?true:false;
    }

    @Override
    public boolean updateTeaImage(TeaImage teaImage) {
        return teaImageDao.updateTeaImage(teaImage)>0?true:false;
    }
}
