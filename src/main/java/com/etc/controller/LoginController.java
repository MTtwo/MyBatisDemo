package com.etc.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.etc.domain.TLogin;
import com.etc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Value("${toad}")
    private String name;

    @Resource
    private LoginService loginService;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String login(){
        System.out.println(name);
        ModelAndView model = new ModelAndView();
        model.addObject("name","[tom,jack]");
        return "login/login";
    }
    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public ModelAndView login2(){
        System.out.println(name);
        ModelAndView model = new ModelAndView();

        model.addObject("name","[tom,jack]");
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public void checkLogin(TLogin login, HttpServletRequest request, HttpServletResponse response) throws Exception{
        TLogin tLogin = loginService.checkLogin(login);
        if (StringUtils.isEmpty(tLogin)){
            String loginJson = JSONUtils.toJSONString(tLogin);
            response.getWriter().print(loginJson);
        }else {
//            HttpSession session = request.getSession();
//            session.setAttribute("login",tLogin);
            //设置响应头
            response.setContentType("text/html;charset=utf-8");
            request.setAttribute("login", tLogin);
            request.getRequestDispatcher("/indexPage/intoIndexPage").forward(request,response);
        }

    }
}
