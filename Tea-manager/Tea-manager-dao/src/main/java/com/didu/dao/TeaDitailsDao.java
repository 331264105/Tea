package com.didu.dao;

import com.didu.domain.Tea;
import com.didu.domain.Tealist;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
public interface TeaDitailsDao {
    @Insert("insert into tealist(teaname,num,price,url,cid,teag,transport,discount) values(#{teaname},#{num},#{price},#{url},#{cid},#{teag},#{transport},#{discount})")
    boolean addTeaDitails(Tealist tealist);

    //删除主页茶详情
    @Delete("delete from tealist where id=#{id}")
    int removeTeaDitails(int id);

    //查找单个茶详情
    @Select("select * from tealist where id=#{id}")
    Tealist selectTeaDitails(int id);

    @Update("update tealist set teaname=#{teaname},num=#{num},price=#{price},url=#{url},cid=#{cid},teag=#{teag},transport=#{transport},discount=#{discount} where id=#{id}")
    int updateTeaDitails(Tealist tealist);
    //查询CID
    @Select("select * from teatype")
    List<Tea> selectTea();
    //查询对应cid的茶商品
    @Select("select * from tealist where cid = #{cid}")
    List<Tealist> selectTealist(int cid);
    //查询ID
    @Select("select id from tealist order by id desc limit 1 ")
    int selectTeaId();
}
