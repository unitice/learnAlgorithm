package com.it.enums.test;

import com.it.enumerate.SeasonEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LY
 * @PackageName:com.it.enums.test
 * @ClassName:EnumTest
 * @date 2021/6/18 11:23
 * 类说明: <br>
 */
@SpringBootTest
public class EnumTest {

    @Test
    public void test01() {
        SeasonEnum autumn = SeasonEnum.AUTUMN;
        switch (autumn){
            case AUTUMN:
                System.out.println(autumn.toString()+"   "+autumn.getSeasonDescription()+"  "+autumn.getSeasonName());
                break;
            case SPRING:
                System.out.println(autumn.toString()+"   "+autumn.getSeasonDescription()+"  "+autumn.getSeasonName());
                break;
            case SUMMER:
                System.out.println(autumn.toString()+"   "+autumn.getSeasonDescription()+"  "+autumn.getSeasonName());
                break;
            case WINTER:
                System.out.println(autumn.toString()+"   "+autumn.getSeasonDescription()+"  "+autumn.getSeasonName());
                break;
        }
    }
}
