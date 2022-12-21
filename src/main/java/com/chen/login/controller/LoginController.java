package com.chen.login.controller;

import com.chen.login.constant.LoginConstant;
import com.chen.login.dto.LoginDTO;
import com.chen.login.service.ILoginService;
import com.chen.utils.AjaxResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("登录控制")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * 登录请求
     * @param dto
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginDTO dto) {
        try {
            return loginService.login(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("登陆失败!"+e.getMessage());
        }
    }

    /**
     * 登出
     * @return
     */
    @PostMapping("/logout")
    public AjaxResult logout(HttpServletRequest request) {
        try {
            // 获取前端请求头中的token
            String token = request.getHeader("token");
            // 删除map中这个token所对应的登录信息
            LoginConstant.loginMap.remove(token);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("登陆失败!"+e.getMessage());
        }
    }

}
