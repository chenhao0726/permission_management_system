package com.chen.mapper;

import com.chen.domain.Department;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DepartmentMapper {
    void update(Department department);
    void deleteById(Serializable id);
    void insert(Department department);
    Department selectById(Serializable id);
    List<Department> selectAll();
}
