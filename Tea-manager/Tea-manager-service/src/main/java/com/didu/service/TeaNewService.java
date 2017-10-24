package com.didu.service;

import com.didu.domain.TeaNew;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
public interface TeaNewService {
    boolean addTeaNew(TeaNew teaNew);
    TeaNew selectTeaNew(int id);
    boolean removeTeaNew(int id);
    boolean updateTeaNew(TeaNew teaNew);
    List<TeaNew> selectTeaNews();
}
