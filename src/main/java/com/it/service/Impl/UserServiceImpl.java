package com.it.service.Impl;

import com.it.entity.User;
import com.it.mapper.UserMapper;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.service.Impl
 * @ClassName:UserServiceImpl
 * @date 2021/6/15 9:33
 * 类说明: <br>
 */
@Service(value = "user")
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public Map<String, Object> insertUserList(List<User> users) {
        Map<String, Object> map = new HashMap<>();
        try {
            users.forEach(user ->{
                if (user.getName().equals("rr")){
                    int i = 10/0;
                }
                String sql = "insert into user(name,password) values ('"+user.getName()+"','"+user.getPassword()+"')";
                userMapper.insertUser(sql);
            });
            map.put("请求成功","1111");
            return map;
        } catch (Exception e) {
            // 手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            map.put("请求失败，事务回滚",e.getMessage());
            return map;
            // 自动回滚
//            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String SystemOut() {
        return "实现类1";
    }
}
