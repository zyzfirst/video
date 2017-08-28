package com.zhiyou100.zy_video.web.controller;

import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService ls;
	@RequestMapping("/login.action")
	public String login(String login_name,String login_pwd,HttpServletRequest req){
		List<Admin> admin = ls.getAdmin(login_name,login_pwd);
		if(admin.size()==0){
			return "forward:/index.jsp";
		}else{
			req.getSession().setAttribute("admin", admin.get(0));
			return "forward:/admin.jsp";
		}
	}
	
	

}
