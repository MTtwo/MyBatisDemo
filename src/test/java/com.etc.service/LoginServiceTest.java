package com.etc.service;

import com.etc.domain.TLogin;
import com.etc.mapper.TLoginMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")

public class LoginServiceTest {
    @Resource
    private LoginService loginService;
    @Autowired
    private TLoginMapper tLoginMapper;
    @Test
    public void getUserTest(){
//        TLogin user = loginService.getUser();
        TLogin tLogin = tLoginMapper.selectByPrimaryKey(1L);
        System.out.println(tLogin.toString());
    }

}