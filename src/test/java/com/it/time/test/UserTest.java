package com.it.time.test;

import com.it.entity.TestUser;
import com.it.entity.User;
import com.it.mapper.TestUserMapper;
import com.it.mapper.UserMapper;
import com.it.service.TestUserService;
import com.it.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:UserTest
 * @date 2021/5/24 11:37
 * 类说明: <br>
 */
@SpringBootTest
public class UserTest {

   /* @Test
    public void test01(){
        List lists = new ArrayList<>();
        User user = new User("ajf",12);
        User user1 = new User("jly",12);
        User user2 = new User("小明",19);
        User user3 = new User("def",20);

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user, user3));


        Collections.sort(users);

        users.forEach(a ->{
            System.out.println(a.toString());
        });
    }

    @Test
    public void test02() {
        SequenceList<String> sequenceList = new SequenceList<>(3);
        sequenceList.insert("君落羽");
        sequenceList.insert(new String[] {"乐乐","风行","光影"});
        sequenceList.insert(4,"纷纷");
        Object[] eles = sequenceList.getEles();
        System.out.println(eles.length);
        for (Object a : sequenceList){
            System.out.println(a +" ");
        }
        System.out.println(sequenceList.length());
    }


    @Test
    public void test03(){
        int[] aa = DataCheckerUtils.genertateRandomArray();
        int[] aa2 = new int[1000000];
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.arraycopy(aa, 0, aa2, 0, aa.length);
        for (int i = 0; i < aa.length ; i++){
            aa2[i] = aa[i];
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        System.out.println(l1);
    }*/

    @Autowired
    private UserService userService;

    @Autowired
    private TestUserService testUserService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test05(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("ll");
        user.setPassword("22");
        list.add(user);
        User user1 = new User();
        user1.setName("ff");
        user1.setPassword("33");
        list.add(user1);
        User user2 = new User();
        user2.setName("rr");
        user2.setPassword("11");
        list.add(user2);
        User user3 = new User();
        user3.setName("jj");
        user3.setPassword("66");
        list.add(user3);


        userService.insertUserList(list);

    }

    @Test
    public void test06(){
        TestUser testUser = new TestUser();
        testUser.setName("aaa");
        testUser.setAge(11);
        testUser.setMoney(BigDecimal.valueOf(11));
        testUser.setCreateDate(new Date());
        testUserService.insert(testUser);
    }

    @Test
    public void test07(){
        String test = "aaa";
        userMapper.createNewTable(test);
    }
}
