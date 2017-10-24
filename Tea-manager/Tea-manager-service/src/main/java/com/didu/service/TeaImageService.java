package com.didu.service;

import com.didu.domain.TeaImage;

/**
 * Created by Administrator on 2017/10/17.
 */
public interface TeaImageService {
    boolean addTeaCarousel(TeaImage teaImage);
    TeaImage selectTeaImage(int id);
    boolean removeTeaImage(int id);
    boolean updateTeaImage(TeaImage teaImage);
}
