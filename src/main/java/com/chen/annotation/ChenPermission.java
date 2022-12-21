package com.chen.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})  // 作用范围，方法和类上面
@Retention(RetentionPolicy.RUNTIME) // 生命周期，在运行时有效
@Documented
public @interface ChenPermission {

    String name();
    String descs() default "";

}
