package com.chen.org.service;

import com.chen.org.domain.Employee;
import com.chen.org.query.DepartmentQuery;
import com.chen.org.query.EmployeeQuery;
import com.chen.query.PageQuery;
import com.chen.utils.PageList;

import java.io.Serializable;
import java.util.List;

public interface IEmployeeService {

    void insertEmp(Employee employee);

    void updateEmpById(Employee employee);

    void deleteEmpById(Serializable id);

    Employee getById(Serializable id);

    List<Employee> getAll();

    /**
     * 查询分页数据
     * @param pageQuery
     * @return
     */
    PageList<Employee> listPage(EmployeeQuery pageQuery);

    /**
     * 批量删除
     * @param ids
     */
    void bachDelete(List<Long> ids);

    Employee getByUsername(String username);
}
