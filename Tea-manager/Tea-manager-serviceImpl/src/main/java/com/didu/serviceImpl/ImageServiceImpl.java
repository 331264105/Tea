package com.didu.serviceImpl;

import com.didu.dao.ImageDao;
import com.didu.domain.Image;
import com.didu.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao idao;
    //上传图片
    @Override
    public boolean addImage(Image image) {
        return (idao.save(image)>0)?true:false;
    }
    //查看批量图片
    @Override
    public List<Image> query() {
        return idao.query();
    }
    //删除图片
    @Override
    public boolean removeImage(int id) {
        return idao.removeImage(id)>0?true:false;
    }

    @Override
    public Image queryI(int id) {
        return idao.queryI(id);
    }

    @Override
    public boolean updateImage(Image picture) {
        return idao.updateImage(picture);
    }
}
