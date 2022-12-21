package com.chen.permission.mapper;

import com.chen.permission.domain.Permission;
import com.chen.permission.query.PermissionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    void loadInsert(Permission permission);

    void deleteAll();

    long loadTotal(PermissionQuery query);

    List<Permission> loadAll(PermissionQuery query);

    List<Permission> permissionTree();

    List<String> loadPermissionSnsByLoginUserId(Long loginUserId);
}
