package com.chen.permission.service.impl;

import com.chen.annotation.ChenPermission;
import com.chen.permission.domain.Permission;
import com.chen.permission.mapper.PermissionMapper;
import com.chen.permission.service.IPermissionScanService;
import com.chen.utils.ClassUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PermissionScanServiceImpl implements IPermissionScanService {

    @Value("${chen.permission.scan-package}")
    private String permissionPackage;// 从配置文件中读取配置权限扫描包

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void scan() {
        // 通过工具类获取特定包下面的所有类
        List<String> allClassName = ClassUtils.getAllClassName(this.permissionPackage);
        // 创建一个存放权限对象的集合
        List<Permission> permissions = new ArrayList<>();
        // 遍历所有的类Controller
        allClassName.forEach(className -> {
            try {
                // 获取字节码对象
                Class<?> clazz = Class.forName(className);
                // 判断Controller类上面是否有自定义注解
                ChenPermission clazzAnnotation = clazz.getAnnotation(ChenPermission.class);
                if (Objects.isNull(clazzAnnotation)) {
                    // 如果类上面没有定义注解就说明当前这个类里面的方法都不需要权限就能访问,就直接跳过,不需要再去处理方法了
                    return;
                }
                // 将类上面的注解解析成一个Permission对象，作为方法权限对象的父亲
                Permission parent = new Permission();
                parent.setName(clazzAnnotation.name()); // 注解的name
                parent.setDescs(clazzAnnotation.descs());   // 注解的描述
                // 获取类url
                RequestMapping clazzRequestMapping =clazz.getAnnotation(RequestMapping.class);
                // 判断当前类如果不为空再去取注解上面的value值，value定义的是一个数组，但默认值是一个对象，要取里面的路径path要取第一个
                if (Objects.nonNull(clazzRequestMapping)){
                    parent.setUrl(clazzRequestMapping.value()[0]);
                }
                parent.setSn(clazz.getSimpleName());    // 把当前类的名称作为唯一权限标识符
                permissions.add(parent);    // 将父Permission对象加入Permission的List集合

                // 获取类中的所有方法
                Method[] methods = clazz.getMethods();
                // 循环所有方法，并判断当前方法是否加了权限主键@ChenPermission
                Arrays.stream(methods).forEach(method -> {
                    // 判断方法上面是否有自定义注解
                    ChenPermission methodAnnotation = method.getAnnotation(ChenPermission.class);
                    if (Objects.isNull(methodAnnotation)) {
                        return;
                    }
                    // 如果有注解，就封装Permission对象，并存到表中
                    Permission permission = new Permission();
                    permission.setName(methodAnnotation.name());
                    permission.setDescs(methodAnnotation.descs());
                    // url 类上的url+方法上的url
                    permission.setUrl(getUrl(parent.getUrl(),method));
                    // 获取唯一权限标识符 sn ==>  类名:方法名
                    permission.setSn(clazz.getSimpleName() + ":" +method.getName());
                    // 设置父权限
                    permission.setParent(parent);
                    // 加入Permission对象集合
                    permissions.add(permission);

                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        /*
         * 执行数据插入操作，直接再加载的时候就把数据库权限表的内容全部删除
         * 然后再重新插入数据
         * 1.先遍历permission集合
         */
        // 判断集合是否为空
        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.forEach(permission -> permissionMapper.loadInsert(permission));
        }
    }

    @SneakyThrows
    public String getUrl(String url, Method method) {
        // 获取方法名上的url
        GetMapping getMapping = method.getAnnotation(GetMapping.class);
        if (Objects.nonNull(getMapping) && getMapping.value().length > 0) {
            url += getMapping.value()[0];
        }
        PostMapping postMapping = method.getAnnotation(PostMapping.class);
        if (Objects.nonNull(postMapping) && postMapping.value().length > 0) {
            url += postMapping.value()[0];
        }
        PutMapping putMapping = method.getAnnotation(PutMapping.class);
        if (Objects.nonNull(putMapping) && putMapping.value().length > 0) {
            url += putMapping.value()[0];
        }
        DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
        if (Objects.nonNull(deleteMapping) && deleteMapping.value().length > 0) {
            url += deleteMapping.value()[0];
        }
        PatchMapping patchMapping = method.getAnnotation(PatchMapping.class);
        if (Objects.nonNull(patchMapping) && patchMapping.value().length > 0) {
            url += patchMapping.value()[0];
        }
        return url;
    }
}
