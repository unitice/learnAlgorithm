package com.it.time.test;

import com.it.Entity.User;
import com.it.algorithm.test.DataCheckerUtils;
import com.it.api.SequenceList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
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
    }
}
