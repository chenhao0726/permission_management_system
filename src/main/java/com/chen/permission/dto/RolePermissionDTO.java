package com.chen.permission.dto;

import lombok.Data;

import java.util.List;

@Data
public class RolePermissionDTO {
    private Long roleId;
    private List<String> permissionSns;
}
