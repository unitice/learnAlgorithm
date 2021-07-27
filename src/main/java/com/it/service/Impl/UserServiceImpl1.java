package com.it.service.Impl;

import com.it.entity.User;
import com.it.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.service.Impl
 * @ClassName:UserServiceImpl1
 * @date 2021/7/6 16:45
 * 类说明: <br>
 */
@Service(value = "user1")
public class UserServiceImpl1 implements UserService {
    @Override
    public Map<String, Object> insertUserList(List<User> users) {
        return null;
    }

    @Override
    public String SystemOut() {
        return "测试类二";
    }
}
