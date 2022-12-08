package com.chen.service.impl;

import com.chen.PermissionAppStarter;
import com.chen.domain.Department;
import com.chen.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PermissionAppStarter.class)
public class DepartmentServiceImplTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void getById() {
        Department byId = departmentService.getById(1L);
        System.out.println(byId);
    }

    @Test
    public void queryAll() {
        departmentService.queryAll().forEach(System.out::println);
    }
}