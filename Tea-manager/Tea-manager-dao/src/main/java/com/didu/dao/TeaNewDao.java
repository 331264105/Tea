package com.didu.dao;

import com.didu.domain.TeaNew;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
public interface TeaNewDao {
    //添加茶新闻
    @Insert("insert into teanew(name,url,time,text,title) values(#{name},#{url},now(),#{text},#{title})")
    int addTeaNew(TeaNew teaNew);
    //查看单个茶新闻
    @Select("select * from teanew where id=#{id}")
    TeaNew selectTeaNew(int id);
    //删除茶新闻
    @Delete("delete from teanew where id=#{id}")
    int removeTeaNew(int id);
    //修改茶新闻
    @Update("update teanew set name=#{name},url=#{url},text=#{text},title=#{title},createtime=now() where id=#{id}")
    int updateTeaNew(TeaNew teaNew);
    //查看所有茶新闻
    @Select("select * from teanew")
    List<TeaNew> selectTeaNews();
}
