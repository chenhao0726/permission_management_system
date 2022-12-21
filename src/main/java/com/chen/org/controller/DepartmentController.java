package com.chen.org.controller;

import com.chen.annotation.ChenPermission;
import com.chen.org.domain.Department;
import com.chen.org.query.DepartmentQuery;
import com.chen.query.PageQuery;
import com.chen.org.service.IDepartmentService;
import com.chen.utils.AjaxResult;
import com.chen.utils.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/dept")
@Api("部门的API,部门相关的CRUD功能")
@ChenPermission(name = "部门管理", descs = "部门权限管理控制")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 修改和添加
     * @param department
     * @return
     */
    @PutMapping
    @ApiOperation("修改/添加" )
    @ChenPermission(name = "修改/添加部门")
    public AjaxResult save(@RequestBody Department department) {
        try {
            if (Objects.isNull(department.getId())) {
                departmentService.save(department);
            } else {
                departmentService.update(department);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    @ChenPermission(name = "删除部门")
    public AjaxResult deleteById(@PathVariable("id")Long id) {
        try {
            departmentService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    @ChenPermission(name = "根据id查询部门")
    public AjaxResult selectById(@PathVariable("id")Long id) {
        try {
            Department department = departmentService.getById(id);
            return AjaxResult.me().setData(department);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    @ApiOperation("查询所有")
    @ChenPermission(name = "查询所有部门")
    public AjaxResult queryAll() {
        try {
            List<Department> departments = departmentService.queryAll();
            return AjaxResult.me().setData(departments);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    @PostMapping
    @ApiOperation("分页查询部门信息")
    @ChenPermission(name = "部门分页查询高级查询")
    public AjaxResult listPageDept(@RequestBody DepartmentQuery pageQuery) {
        try {
            PageList<Department> departmentPageList = departmentService.listPage(pageQuery);
            return AjaxResult.me().setData(departmentPageList);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @PatchMapping
    @ApiOperation("批量删除")
    @ChenPermission(name = "部门的批量删除")
    public AjaxResult batchDeleteDept(@RequestBody List<Long> ids) {
        try {
            departmentService.bachDelete(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @GetMapping("/tree")
    @ApiOperation("部门树，关系")
    @ChenPermission(name = "部门树")
    public AjaxResult deptTree() {
        try {
            List<Department> deptTree = departmentService.deptTree();
            return AjaxResult.me().setData(deptTree);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

}
