package com.chen.controller;

import com.chen.domain.Department;
import com.chen.service.IDepartmentService;
import com.chen.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/department")
@Api(value = "部门的API,部门相关的CRUD功能")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 修改和添加
     * @param department
     * @return
     */
    @PutMapping
    @ApiOperation(value = "修改/添加" )
    public AjaxResult save(Department department) {
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
    @ApiOperation(value = "删除")
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
    @ApiOperation(value = "根据id查询")
    public AjaxResult selectById(@PathVariable("id")Long id) {
        try {
            Department department = departmentService.getById(id);
            return AjaxResult.me().setData(department);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public AjaxResult queryAll() {
        try {
            List<Department> departments = departmentService.queryAll();
            return AjaxResult.me().setData(departments);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

}
