package com.chen.permission.controller;

import com.chen.annotation.ChenPermission;
import com.chen.permission.domain.Role;
import com.chen.permission.dto.RolePermissionDTO;
import com.chen.permission.query.RoleQuery;
import com.chen.permission.service.IRoleService;
import com.chen.utils.AjaxResult;
import com.chen.utils.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api("角色管理")
@RestController
@RequestMapping("/role")
@ChenPermission(name = "角色管理",descs = "角色权限控制")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 修改/添加
     * @param role
     * @return
     */
    @PutMapping
    @ApiOperation("修改/新增")
    @ChenPermission(name = "修改/新增")
    public AjaxResult save(@RequestBody Role role) {
        // 判断是否携带id值
        try {
            if (Objects.isNull(role.getId())) {
                roleService.insertRole(role);
            } else {
                roleService.updateRole(role);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/{id}")
    @ChenPermission(name = "根据id删除角色")
    public AjaxResult deleteByIdRole(@PathVariable("id")Long id) {
        try {
            roleService.deleteByIdRole(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }

    @ApiOperation("根据id查询角色")
    @GetMapping("/{id}")
    @ChenPermission(name = "根据id查询角色")
    public AjaxResult selectByIdRole(@PathVariable("id")Long id) {
        try {
            Role role = roleService.selectByIdRole(id);
            return AjaxResult.me().setData(role);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }

    @ApiOperation("查询所有角色")
    @GetMapping
    @ChenPermission(name = "查询所有角色")
    public AjaxResult queryAllRole() {
        try {
            List<Role> roles = roleService.queryAllRole();
            return AjaxResult.me().setData(roles);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }


    @ApiOperation("高级查询/分页查询")
    @PostMapping
    @ChenPermission(name = "高级查询/分页查询")
    public AjaxResult queryAllPageRole(@RequestBody RoleQuery roleQuery) {
        try {
            PageList<Role> rolePageList = roleService.queryAllPageRole(roleQuery);
            return AjaxResult.me().setData(rolePageList);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @ApiOperation("批量删除角色")
    @PatchMapping
    @ChenPermission(name = "批量删除")
    public AjaxResult batchDeleteRole(@RequestBody List<Long> ids) {
        try {
            roleService.batchDeleteRole(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }

    @ApiOperation("角色权限保存")
    @PostMapping("/saveRolePer")
    @ChenPermission(name = "角色权限保存")
    public AjaxResult saveRolePermission(@RequestBody RolePermissionDTO dto) {
        try {
            roleService.saveRolePermission(dto);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作错误："+e.getMessage());
        }
    }


    @ApiOperation("根据id查询角色权限")
    @GetMapping("/getRolePer/{id}")
    @ChenPermission(name = "根据id查询角色权限")
    public AjaxResult getByIdRolePermission(@PathVariable("id")Long roleId) {
        try {
            List<String> sns = roleService.getByIdRolePermission(roleId);
            return AjaxResult.me().setData(sns);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("错误："+e.getMessage());
        }
    }

}
