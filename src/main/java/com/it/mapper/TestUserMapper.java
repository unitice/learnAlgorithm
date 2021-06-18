package com.it.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.it.entity.TestUser;

@Mapper
public interface TestUserMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TestUser> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TestUser getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param testUser 新增的记录
     * @return 返回影响行数
     */
	int insert(TestUser testUser);
	
	/**
     * 新增，忽略null字段
     *
     * @param testUser 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TestUser testUser);
	
	/**
     * 修改，修改所有字段
     *
     * @param testUser 修改的记录
     * @return 返回影响行数
     */
	int update(TestUser testUser);
	
	/**
     * 修改，忽略null字段
     *
     * @param testUser 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TestUser testUser);
	
	/**
     * 删除记录
     *
     * @param testUser 待删除的记录
     * @return 返回影响行数
     */
	int delete(TestUser testUser);
	
}