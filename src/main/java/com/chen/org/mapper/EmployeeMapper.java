package com.chen.org.mapper;

import com.chen.org.domain.Employee;
import com.chen.org.query.EmployeeQuery;
import com.chen.query.PageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface EmployeeMapper {

    void insertEmp(Employee employee);

    void updateEmpById(Employee employee);

    void deleteEmpById(Serializable id);

    Employee selectById(Serializable id);

    List<Employee> queryAll();

    /**
     * 统计数据
     * @param pageQuery
     * @return
     */
    long queryTotal(EmployeeQuery pageQuery);

    /**
     * 查询分页数据
     * @param pageQuery
     * @return
     */
    List<Employee> queryData(EmployeeQuery pageQuery);

    /**
     * 批量删除
     * @param ids
     */
    void bachDelete(List<Long> ids);

    /**
     * 新增角色
     * @param empId
     * @param roleId
     */
    void insertEmpRole(@Param("empId") Long empId,@Param("roleId") Long roleId);

    /**
     * 更新角色
     * @param empId
     * @param roleId
     */
    void updateEmpRole(@Param("empId") Long empId,@Param("roleId") Long roleId);

    Employee getByUsername(String username);
}
