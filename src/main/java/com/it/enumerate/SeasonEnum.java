package com.it.enumerate;

/**
 * @author LY
 * @PackageName:com.it.enumerate
 * @ClassName:SeasonEnum
 * @date 2021/6/18 11:09
 * 枚举说明: <br>
 */
public enum SeasonEnum {

    /** 天气 季节*/
    SPRING("春天","春风又绿江南岸"),
    SUMMER("夏天","映日荷花别样红"),
    AUTUMN("秋天","秋水共长天一色"),
    WINTER("冬天","窗含西岭千秋雪");

    /** 天气*/
    private final String seasonName;
    /** 季节*/
    private final String seasonDescription;

    SeasonEnum(String seasonName, String seasonDescription) {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescription() {
        return seasonDescription;
    }
}
