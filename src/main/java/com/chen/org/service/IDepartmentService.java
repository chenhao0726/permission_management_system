package com.chen.org.service;

import com.chen.org.domain.Department;
import com.chen.org.query.DepartmentQuery;
import com.chen.query.PageQuery;
import com.chen.utils.PageList;

import java.io.Serializable;
import java.util.List;

public interface IDepartmentService {
    void update(Department department);
    void deleteById(Serializable id);
    void save(Department department);
    Department getById(Serializable id);
    List<Department> queryAll();

    /**
     * 查询分页数据
     * @param pageQuery
     * @return
     */
    PageList<Department> listPage(DepartmentQuery pageQuery);

    /**
     * 批量删除
     * @param ids
     */
    void bachDelete(List<Long> ids);

    /**
     * 部门树
     * @return
     */
    List<Department> deptTree();
}
