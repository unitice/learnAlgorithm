package com.it.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LY
 * @PackageName:com.it.mapper
 * @ClassName:CreateTables
 * @date 2021/7/6 11:36
 * 接口说明: <br>
 */
@Mapper
public interface CreateTablesMapper {

    /**
     * 创建新的数据表
     * @param sql 创建表的语句
     */
    void createNewTable(@Param("sql")String sql);
}
