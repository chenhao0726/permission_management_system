package com.chen.org.mapper;

import com.chen.org.domain.Department;
import com.chen.org.query.DepartmentQuery;
import com.chen.query.PageQuery;
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
    /**
     * 统计数据
     * @param pageQuery
     * @return
     */
    long queryTotal(DepartmentQuery pageQuery);

    /**
     * 分页查询数据
     * @param pageQuery
     * @return
     */
    List<Department> queryAllPage(DepartmentQuery pageQuery);

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
