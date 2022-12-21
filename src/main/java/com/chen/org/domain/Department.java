package com.chen.org.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {;
    private Long id;    // 主键id
    private String name;    // 部门名称
    private String intro ;  // 部门描述
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;   // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;   // 修改时间
    private Long manager_id;    // 对应员工表id
    private Long parent_id;     // 父id
    private String path;    // 路径
    private Integer state;  // 状态
    // 多对一，部门id-员工名称
    private Employee manager;
    // 多对一，parent_id - 部门名称
    private Department parent;

    private List<Department> children;


}
