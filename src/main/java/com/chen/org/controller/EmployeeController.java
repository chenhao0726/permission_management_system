package com.chen.org.controller;

import com.chen.annotation.ChenPermission;
import com.chen.org.domain.Employee;
import com.chen.org.query.EmployeeQuery;
import com.chen.query.PageQuery;
import com.chen.org.service.IEmployeeService;
import com.chen.utils.AjaxResult;
import com.chen.utils.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/emp")
@Api("员工的API，员工的CRUD管理")
@ChenPermission(name = "员工管理", descs = "员工权限管理控制")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PutMapping
    @ApiOperation("修改/添加")
    @ChenPermission(name = "修改/添加员工")
    public AjaxResult empSave(@RequestBody Employee employee) {
        System.out.println(employee);
        try {
            if (Objects.isNull(employee.getId())) {
                employeeService.insertEmp(employee);
                return AjaxResult.me();
            } else {
                employeeService.updateEmpById(employee);
                return AjaxResult.me();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除")
    @ChenPermission(name = "根据id删除员工")
    public AjaxResult empDeleteById(@PathVariable("id")Long id) {
        try {
            employeeService.deleteEmpById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    @ChenPermission(name = "根据id查询员工")
    public AjaxResult empSelectById(@PathVariable("id")Long id) {
        try {
            Employee employee = employeeService.getById(id);
            return AjaxResult.me().setData(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation("查询所有")
    @ChenPermission(name = "查询所有员工")
    public AjaxResult empQuery() {
        try {
            List<Employee> employees = employeeService.getAll();
            return AjaxResult.me().setData(employees);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败："+e.getMessage());
        }
    }

    @PostMapping
    @ApiOperation("分页查询员工信息包括员工角色")
    @ChenPermission(name = "员工分页/高级查询")
    public AjaxResult listPage(@RequestBody EmployeeQuery query) {
        try {
            PageList<Employee> employeePageList = employeeService.listPage(query);
            return AjaxResult.me().setData(employeePageList);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("操作失败！"+e.getMessage());
        }
    }

    @PatchMapping
    @ApiOperation("批量删除")
    @ChenPermission(name = "员工批量删除")
    public AjaxResult batchDeleteEmp(@RequestBody List<Long> ids) {
        try {
            employeeService.bachDelete(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除失败："+e.getMessage());
        }
    }

}
