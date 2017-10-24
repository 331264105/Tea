package com.didu.dao;

import com.didu.domain.Image;
import com.didu.domain.Tea;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2017/10/13.
 */
public interface TeaTypeDao {
    @Insert("insert into TeaTypeImage(title,url,cid) values(#{title},#{url},#{cid})")
    /*@Options(keyProperty="id",useGeneratedKeys=true)*/
    int addImage(Tea teaType);
}
