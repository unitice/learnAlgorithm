package com.it.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LY
 * @PackageName:com.it.Mapper
 * @ClassName:UserMapper
 * @date 2021/6/15 9:49
 * 类说明: <br>
 */
@Mapper
public interface UserMapper {

    void insertUser(@Param("sql") String sql);

    void createNewTable(@Param("tableName")String tableName);
}
