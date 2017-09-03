package com.zhiyou100.zy_video.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.LoginService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	LoginService ls;
	@RequestMapping("/login.action")
	public String login(Admin ad,HttpServletRequest req){
		List<Admin> admin = ls.getAdmin(ad);
		if(admin.size()==0){
			return "/admin/index";
		}else{
			req.getSession().setAttribute("admin", admin.get(0));
			return "forward:/admin/video/video.action";
		}
	}
	
	@RequestMapping("/index.action")
	public String index(){
		return "/admin/index";
	}
	
	@RequestMapping("/adminLogout.action")
	public String adminLogout(HttpSession session){
		session.removeAttribute("admin");;
		return "redirect:/admin/index.action";
	}
	
	

}
