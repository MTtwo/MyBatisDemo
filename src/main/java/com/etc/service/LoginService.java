package com.etc.service;

import com.etc.domain.TLogin;
import com.etc.mapper.TLoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private TLoginMapper tLoginMapper;

    public TLogin getUser(){
        TLogin tLogin = tLoginMapper.selectByPrimaryKey(1L);
        return tLogin;
    }

    /**
     * 登入时的校验
     * @param login
     * @return
     */
    public TLogin checkLogin(TLogin login){
        TLogin tLogin = tLoginMapper.checkLogin(login);
        return tLogin;
    }
}
