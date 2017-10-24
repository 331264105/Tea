package com.didu.dao;

import com.didu.domain.Admin;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/10/23.
 */
public interface AdminDao {
    @Select("select * from admin where username=#{username} and password=#{password} and num=#{num}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "num", column = "num"),
    })
    Admin login(Admin admin);
}
