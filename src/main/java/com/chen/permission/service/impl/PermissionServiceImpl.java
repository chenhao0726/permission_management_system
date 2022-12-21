package com.chen.permission.service.impl;

import com.chen.permission.domain.Permission;
import com.chen.permission.mapper.PermissionMapper;
import com.chen.permission.query.PermissionQuery;
import com.chen.permission.service.IPermissionService;
import com.chen.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void deleteAll() {
        permissionMapper.deleteAll();
    }

    @Override
    public PageList<Permission> loadAll(PermissionQuery query) {
        // 统计所有数据，如果有再执行查询
        long total = permissionMapper.loadTotal(query);
        if (total > 0) {
            List<Permission> permissions = permissionMapper.loadAll(query);
            return new PageList<>(total,permissions);
        }
        return new PageList<>();
    }

    @Override
    public List<Permission> permissionTree() {
        return permissionMapper.permissionTree();
    }

    @Override
    public List<String> getPermissionSnsByLoginUserId(Long loginUserId) {
        return permissionMapper.loadPermissionSnsByLoginUserId(loginUserId);
    }
}
