package com.chen.org.service.impl;

import com.chen.org.domain.Department;
import com.chen.org.mapper.DepartmentMapper;
import com.chen.org.query.DepartmentQuery;
import com.chen.query.PageQuery;
import com.chen.org.service.IDepartmentService;
import com.chen.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public void update(Department department) {
        // 设置修改时间为当前系统时间
        department.setUpdate_time(new Date());
        Department parent = department.getParent();
        String path="";
        // 它为空,说明前端没有选择父部门,说明当前就是一级部门
        if (Objects.isNull(parent) || Objects.isNull(parent.getId())) {
            path = "/"+department.getId();
        } else {
            // 拿到当前父部门信息
            parent = departmentMapper.selectById(parent.getId());
            // 设置路径
            path = parent.getPath()+"/"+department.getId();
        }
        // 将path赋值给department
        department.setPath(path);
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
        // 设置新增时间为当前系统时间
        department.setCreate_time(new Date());
        departmentMapper.insert(department);
        // 新建部门，设置path路径
        // 传过来的为父部门id，只需要通过父部门id去查询是否有数据，有数据就把父部门的路径+/+自己的id，path=父部门path/自己id
        // 没有的话就path= /自己id
        // 获取前端的父部门对象
        Department parent = department.getParent();
        String path="";
        // 它为空,说明前端没有选择父部门,说明当前就是一级部门
        if (Objects.isNull(parent) || Objects.isNull(parent.getId())) {
            path = "/"+department.getId();
        } else {
            // 拿到当前父部门信息
            parent = departmentMapper.selectById(parent.getId());
            // 设置路径
            path = parent.getPath()+"/"+department.getId();
        }
        // 将path赋值给department
        department.setPath(path);
        // 执行修改操作
        departmentMapper.update(department);
    }

    @Override
    public Department getById(Serializable id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public List<Department> queryAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public PageList<Department> listPage(DepartmentQuery pageQuery) {
        // 查询总条数
        long total = departmentMapper.queryTotal(pageQuery);
        // 判断是否大于0
        if (total >0) {
            List<Department> departments = departmentMapper.queryAllPage(pageQuery);
            return new PageList<>(total,departments);
        }
        return new PageList<>();
    }

    @Override
    @Transactional
    public void bachDelete(List<Long> ids) {
        departmentMapper.bachDelete(ids);
    }

    @Override
    public List<Department> deptTree() {
        return departmentMapper.deptTree();
    }
}
