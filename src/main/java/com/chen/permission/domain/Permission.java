package com.chen.permission.domain;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private Long id;
    private String name;
    private String url;
    private String descs;
    private String sn;
    private Permission parent;
    // 一对多，查询一二级权限
    private List<Permission> children;
}
