package com.it.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.entity
 * @ClassName:XmlEntity
 * @date 2021/6/29 13:50
 * 类说明: <br>
 */
@Data
public class XmlEntity {

    /**
     * 结点名称
     */
    private String name;

    /**
     * 属性集合
     */
    private Map<String,Object> attribute;


    /**
     * 值
     */
    private String text;

    /**
     * 子结点集合
     */
    private List<XmlEntity> xmlEntities;


}
