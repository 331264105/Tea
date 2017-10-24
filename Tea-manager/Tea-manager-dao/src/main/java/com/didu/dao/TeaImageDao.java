package com.didu.dao;

import com.didu.domain.TeaImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2017/10/17.
 */
public interface TeaImageDao {
    @Insert("insert into teaimage(name,url,cid,pid,createtime) values(#{name},#{url},#{cid},#{pid},now())")
    int addTeaCarousel(TeaImage teaImage);

    @Select("select * from teaimage where id=#{id}")
    TeaImage selectTeaImage(int id);

    @Delete("delete * from teaimage where id = #{id}")
    int removeTeaImage(int id);

    @Update("update teaimage set name=#{name},url=#{url},createtime=now() where id=#{id}")
    int updateTeaImage(TeaImage teaImage);
}
