package com.chen.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {

    public static List<String> getAllClassName(String packageNames) {
        // 多个路径进行拆分
        String[] split = packageNames.split(",");
        List<String> result = new ArrayList<>();
        Arrays.stream(split).forEach(packageName -> {
            // 包相对路径
            String packagePath = packageName.replace(".", "/");
            // 获取classpath
            URL url = ClassLoader.getSystemResource("");
            // 获取classapth+packagePath,就是完整的路径
            File[] files = new File(url.getPath() + packagePath)
                    .listFiles(file -> file.getName().endsWith(".class"));
            assert files != null;
            Arrays.stream(files).forEach(file -> {
                // 输出类名名称
                String fileName = file.getName();
                fileName = fileName.substring(0, fileName.lastIndexOf("."));

                // 全限定类名
                String allName = packageName + "." + fileName;
                // 将字节码对象添加到集合
                result.add(allName);
            });
        });
        return result;
    }
}
