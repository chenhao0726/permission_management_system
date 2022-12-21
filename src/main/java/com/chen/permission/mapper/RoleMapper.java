package com.chen.permission.mapper;

import com.chen.permission.dto.RolePermissionDTO;
import com.chen.permission.query.RoleQuery;
import com.chen.permission.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RoleMapper {

    void deleteByIdRole(Serializable id);

    void updateRole(Role role);

    void insertRole(Role role);

    Role selectByIdRole(Serializable id);

    List<Role> queryAllRole();

    long totalRole(RoleQuery query);

    List<Role> queryAllPageRole(RoleQuery query);
    // 批量删除角色
    void batchDeleteRole(List<Long> ids);
    // 批量删除角色权限
    void batchDeleteRolePermission(List<Long> ids);
    // 根据id角色id删除角色权限
    void deleteByIdRolePermission(Long roleId);
    // 批量添加角色权限
    void saveRolePermission(@Param("roleId") Long roleId,@Param("rolePerSns") List<String> rolePerSns);

    List<String> selectByIdRolePer(Long roleId);

}
