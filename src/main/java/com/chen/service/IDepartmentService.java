package com.chen.service;

import com.chen.domain.Department;

import java.io.Serializable;
import java.util.List;

public interface IDepartmentService {
    void update(Department department);
    void deleteById(Serializable id);
    void save(Department department);
    Department getById(Serializable id);
    List<Department> queryAll();
}
