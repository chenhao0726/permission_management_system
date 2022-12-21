package com.chen.permission.service;

import com.chen.permission.dto.RolePermissionDTO;
import com.chen.permission.query.RoleQuery;
import com.chen.permission.domain.Role;
import com.chen.utils.PageList;

import java.io.Serializable;
import java.util.List;

public interface IRoleService {

    void deleteByIdRole(Serializable id);

    void updateRole(Role role);

    void insertRole(Role role);

    Role selectByIdRole(Serializable id);

    List<Role> queryAllRole();

    PageList<Role> queryAllPageRole(RoleQuery query);

    void batchDeleteRole(List<Long> ids);

    void saveRolePermission(RolePermissionDTO dto);

    List<String> getByIdRolePermission(Long roleId);
}
