package com.chen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {;
    private Long id;
    private String name;
    private String intro ;
    private Date create_time;
    private Date update_time;
    private Long manager_id;
    private Long parent_id;
    private String path;
    private Integer state;
    private Employee emp;
    private Department dept;

}
