package com.it.service;

import com.it.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.service
 * @ClassName:UserService
 * @date 2021/6/15 9:33
 * 接口说明: <br>
 */
public interface UserService {

    Map<String, Object>  insertUserList(List<User> users);

}
