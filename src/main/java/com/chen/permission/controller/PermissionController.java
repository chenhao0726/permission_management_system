package com.chen.permission.controller;

import com.chen.annotation.ChenPermission;
import com.chen.permission.domain.Permission;
import com.chen.permission.query.PermissionQuery;
import com.chen.permission.service.IPermissionService;
import com.chen.utils.AjaxResult;
import com.chen.utils.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@ChenPermission(name = "权限管理", descs = "权限管理控制")
@Api("权限管理")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    /*
     * 高级查询/分页查询
     */
    @PostMapping
    @ChenPermission(name = "权限高级查询")
    @ApiOperation("高级查询/分页查询")
    public AjaxResult loadAll(@RequestBody PermissionQuery query) {
        try {
            PageList<Permission> pageList = permissionService.loadAll(query);
            return AjaxResult.me().setData(pageList);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }

    @ApiOperation("查询权限树")
    @GetMapping("/tree")
    @ChenPermission(name = "查询权限树")
    public AjaxResult queryPermissionTree() {
        try {
            List<Permission> permissionTree =permissionService.permissionTree();
            return AjaxResult.me().setData(permissionTree);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }
}
