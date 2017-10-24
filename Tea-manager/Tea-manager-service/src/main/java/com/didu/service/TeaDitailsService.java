package com.didu.service;

import com.didu.domain.Tea;
import com.didu.domain.Tealist;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
public interface TeaDitailsService {
    boolean addTeaDitails(Tealist tealist);

    boolean removeTeaDitails(int id);

    Tealist selectTeaDitails(int id);

    boolean updateTeaDitails(Tealist tealist);

    List<Tea> selectTea();

    List<Tealist> selectTealist(int cid);

    int selectTeaId();
}
