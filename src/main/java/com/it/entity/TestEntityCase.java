package com.it.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author LY
 * @PackageName:com.it.entity
 * @ClassName:TestEntityCase
 * @date 2021/7/6 14:48
 * 类说明: <br>
 */
@Data
public class TestEntityCase {

    private List<MultipartFile> files;

    private String name;

    private Integer age;


}
