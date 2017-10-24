package com.didu.service;

import com.didu.domain.Image;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public interface ImageService {
    boolean addImage(Image image);

    List<Image> query();

    boolean removeImage(int id);

    Image queryI(int id);

    boolean updateImage(Image picture);
}
