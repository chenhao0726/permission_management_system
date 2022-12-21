package com.chen.org.domain;

import com.chen.permission.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;    // 主键id
    private String username;    // 用户名
    private String password;    // 面密码
    private String email;   // 邮箱
    private String headImage;   // 图片地址
    private Integer age;    // 年龄
    private Long department_id; // 对应部门id
    // 多对一，员工-部门
    private Department dept;
    // 多对一，员工-角色
    private Role role;
}
