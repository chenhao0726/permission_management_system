package com.chen.org.service.impl;

import com.chen.org.domain.Employee;
import com.chen.org.mapper.EmployeeMapper;
import com.chen.org.query.EmployeeQuery;
import com.chen.org.service.IEmployeeService;
import com.chen.permission.domain.Role;
import com.chen.query.PageQuery;
import com.chen.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl implements IEmployeeService {

    // 注入mapper
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public void insertEmp(Employee employee) {
        Role role = employee.getRole();
        employeeMapper.insertEmp(employee);
        if (Objects.nonNull(employee.getRole()) && Objects.nonNull(role.getId())) {
            employeeMapper.insertEmpRole(employee.getId(),role.getId());
        }
    }

    @Override
    @Transactional
    public void updateEmpById(Employee employee) {
        employeeMapper.updateEmpById(employee);
        Role role = employee.getRole();
        if (Objects.nonNull(employee.getRole()) && Objects.nonNull(role.getId())) {
            employeeMapper.updateEmpRole(employee.getId(),role.getId());
        }
    }

    @Override
    @Transactional
    public void deleteEmpById(Serializable id) {
        employeeMapper.deleteEmpById(id);
    }

    @Override
    public Employee getById(Serializable id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.queryAll();
    }

    @Override
    public PageList<Employee> listPage(EmployeeQuery pageQuery) {
        // 查询数据总条数
        long total = employeeMapper.queryTotal(pageQuery);
        // 判断数据是否大于0
        if (total > 0) {
            List<Employee> employeeList = employeeMapper.queryData(pageQuery);
            return new PageList<>(total,employeeList);
        }
        return new PageList<>();
    }

    @Override
    @Transactional
    public void bachDelete(List<Long> ids) {
        employeeMapper.bachDelete(ids);
    }

    @Override
    public Employee getByUsername(String username) {
        return employeeMapper.getByUsername(username);
    }
}
