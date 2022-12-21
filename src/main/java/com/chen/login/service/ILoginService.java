package com.chen.login.service;

import com.chen.login.dto.LoginDTO;
import com.chen.utils.AjaxResult;

public interface ILoginService {

    AjaxResult login(LoginDTO dto);
}
