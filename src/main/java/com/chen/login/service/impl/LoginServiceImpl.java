package com.chen.login.service.impl;

import com.chen.login.constant.LoginConstant;
import com.chen.login.dto.LoginDTO;
import com.chen.login.service.ILoginService;
import com.chen.org.domain.Employee;
import com.chen.org.service.IEmployeeService;
import com.chen.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 登录事务
     * @param dto
     * @return
     */
    @Override
    public AjaxResult login(LoginDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        // 1. 参数非空校验
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("用户名或密码不能为空!请检查后重新提交!");
        }
        // 2. 根据username去查询用户密码
        Employee employee = employeeService.getByUsername(username);
        // 2.1 如果employee为空，说明用户名错误
        if (Objects.isNull(employee)) {
            throw new RuntimeException("用户名或密码错误，请重新输入！");
        }
        // 3 判断用户密码是否正确
        if (!password.equals(employee.getPassword())) {
            throw new RuntimeException("用户名或密码错误，请重新输入！");
        }
        // 登录成功
        // 4 通过uuid随机生成字符串作为用户登录的唯一凭证token
        String token = UUID.randomUUID().toString();
        // 5. 将token和用户信息存入登录用户信息的常量map中
        LoginConstant.loginMap.put(token,employee);
        // 将token传给前端
        return AjaxResult.me().setData(token);
    }
}
