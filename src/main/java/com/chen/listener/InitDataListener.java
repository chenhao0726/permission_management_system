package com.chen.listener;

import com.chen.permission.service.IPermissionScanService;
import com.chen.permission.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitDataListener implements ServletContextListener{

    @Autowired
    private IPermissionScanService permissionScanService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化.......................");
        permissionService.deleteAll();
        permissionScanService.scan();
        System.out.println("初始化完成....................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁..........................");
    }
}
