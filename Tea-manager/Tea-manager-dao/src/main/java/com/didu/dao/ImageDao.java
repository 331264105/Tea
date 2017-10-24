package com.didu.dao;

import com.didu.domain.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface ImageDao {
    //添加图片
    @Insert("insert into Image(name,path,createtime) values(#{name},#{path},now())")
    /*@Options(keyProperty="id",useGeneratedKeys=true)*/
    int save(Image image);

    //批量查找图片
    @Select("select * from image")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "path", column = "path"),
            @Result(property = "createtime", column = "createtime"),
    })
    List<Image> query();

    //删除图片
    @Delete("delete from image where id=#{id}")
    int removeImage(int id);

    //查看单张图片
    @Select("select * from image where id=#{id}")
    Image queryI(int id);

    //修改图片
    @Update("update image set name=#{name},path=#{path},createtime=#{createtime} where id=#{id}")
    boolean updateImage(Image image);

}
