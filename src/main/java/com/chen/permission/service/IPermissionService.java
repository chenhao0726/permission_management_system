package com.chen.permission.service;

import com.chen.permission.domain.Permission;
import com.chen.permission.query.PermissionQuery;
import com.chen.utils.PageList;

import java.util.List;

public interface IPermissionService {
    void deleteAll();

    PageList<Permission> loadAll(PermissionQuery query);

    List<Permission> permissionTree();

    List<String> getPermissionSnsByLoginUserId(Long loginUserId);
}
