package com.it.service;

import com.it.entity.TestUser;
import com.it.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TestUser> listAll() {
    	return testUserMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TestUser getById(Integer id) {
    	return testUserMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param testUser 新增的记录
     * @return 返回影响行数
     */
    public int insert(TestUser testUser) {
    	return testUserMapper.insert(testUser);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param testUser 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TestUser testUser) {
    	return testUserMapper.insertIgnoreNull(testUser);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param testUser 修改的记录
     * @return 返回影响行数
     */
    public int update(TestUser testUser) {
    	return testUserMapper.update(testUser);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param testUser 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TestUser testUser) {
    	return testUserMapper.updateIgnoreNull(testUser);
    }
	
    /**
     * 删除记录
     *
     * @param testUser 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TestUser testUser) {
    	return testUserMapper.delete(testUser);
    }
	
}