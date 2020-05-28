package com.ttttse.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: hn-thymeleaf-layui
 * @description: layuitable
 * @author: ttttse
 * @create: 2020-05-24 00:53
 **/
@Data
public class LayUITable {
    private int code;
    private String msg;
    private long count;
    private List<?>Data;
}
