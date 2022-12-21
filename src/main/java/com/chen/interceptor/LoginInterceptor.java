package com.chen.interceptor;

import com.chen.annotation.ChenPermission;
import com.chen.login.constant.LoginConstant;
import com.chen.org.domain.Employee;
import com.chen.permission.service.IPermissionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 登录拦截
        // 1.1 从请求中获取token
        String token = request.getHeader("token");
        // 1.2 根据token去常量map中去获取登录用户信息
        Employee loginUser = LoginConstant.loginMap.get(token);
        // 1.3 判断当前登录用户的信息是否存在，空就说明用户未登录，需要拦截
        if (Objects.isNull(loginUser)) {
            // 向前端传递未登录信息
            response.getWriter().println("{\"success\":false,\"message\":\"Not Login\"}");
            return false;
        }

        // 2 权限拦截
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            // 2.1 判断当前资源需不需要权限来访问
            ChenPermission annotation = method.getAnnotation(ChenPermission.class);
            if(Objects.isNull(annotation)){
                // 注解为空,说明当前方法不需要权限就能直接访问 放行
                return true;
            }
            // 2.2 获取访问这个资源所需要的权限   类名:方法名
            String sn = method.getDeclaringClass().getSimpleName()+":"+method.getName();

            // 2.3 获取当前登陆用户他拥有的所有的权限 - 只需要知道当前登陆用户拥有的权限sn有哪一些就可以了,不需要知道权限的所有信息
            List<String> sns = permissionService.getPermissionSnsByLoginUserId(loginUser.getId());

            // 2.4 判断资源所需要的权限,在不在登录用户他拥有的权限里面
            if(!sns.contains(sn)){
                // 不存在
                response.getWriter().println("{\"success\":false,\"message\":\"noPermission\"}");   // 向前端响应错误信息
                return false;       // 拦截
            }
        }
        return true;
    }
}
