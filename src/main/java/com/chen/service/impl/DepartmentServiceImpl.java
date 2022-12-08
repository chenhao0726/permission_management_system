package com.chen.service.impl;

import com.chen.domain.Department;
import com.chen.mapper.DepartmentMapper;
import com.chen.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    @Transactional
    public void deleteById(Serializable id) {
        departmentMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department getById(Serializable id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public List<Department> queryAll() {
        return departmentMapper.selectAll();
    }
}
