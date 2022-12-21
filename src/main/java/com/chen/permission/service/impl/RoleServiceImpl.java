package com.chen.permission.service.impl;

import com.chen.permission.dto.RolePermissionDTO;
import com.chen.permission.query.RoleQuery;
import com.chen.permission.domain.Role;
import com.chen.permission.mapper.RoleMapper;
import com.chen.permission.service.IRoleService;
import com.chen.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void deleteByIdRole(Serializable id) {
        // 删除角色的时候把角色的权限也删除
        roleMapper.deleteByIdRole(id);
        roleMapper.deleteByIdRolePermission((Long) id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }

    @Override
    public Role selectByIdRole(Serializable id) {
        return roleMapper.selectByIdRole(id);
    }

    @Override
    public List<Role> queryAllRole() {
        return roleMapper.queryAllRole();
    }

    @Override
    public PageList<Role> queryAllPageRole(RoleQuery query) {
        // 先统计数据
        long totalRole = roleMapper.totalRole(query);
        // 如果总数大于0再执行分页查询
        if (totalRole > 0) {
            List<Role> roles = roleMapper.queryAllPageRole(query);
            return new PageList<>(totalRole, roles);
        }
        return new PageList<>();
    }

    @Override
    public void batchDeleteRole(List<Long> ids) {
        roleMapper.batchDeleteRole(ids);
    }

    @Override
    public void saveRolePermission(RolePermissionDTO dto) {
        Long roleId = dto.getRoleId();
        // 先去根据id删除所有角色的权限信息
        roleMapper.deleteByIdRolePermission(roleId);
        System.out.println(roleId);
        System.out.println(dto.getPermissionSns());
        roleMapper.saveRolePermission(roleId,dto.getPermissionSns());
    }

    @Override
    public List<String> getByIdRolePermission(Long roleId) {
        return roleMapper.selectByIdRolePer(roleId);
    }
}
