package com.zhiyou100.zy_video.web.controller.front;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy_video.model.Json;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.service.FrontUserService;
@Controller
@RequestMapping("/front/user")
public class UserController {
	
	@Autowired
	FrontUserService fus;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public Json regist(User user,HttpSession session){
		Json js = new Json();
		List<User> list = fus.findUserByMail(user);
		if(list.size() == 0){
			user.setInsertTime(new Timestamp(System.currentTimeMillis()));
			int i = fus.regist(user);
			if(i != 0){
				js.setSuccess(true);
				session.setAttribute("email", user.getEmail());
			}
		}
		else{
			js.setMessage("regist error");
		}
		return js;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Json login(User user,HttpSession session){
		Json js = new Json();
		List<User> list = fus.findUserByMailAndPwd(user);
		if(list.size() != 0){
			js.setSuccess(true);
			session.setAttribute("_front_user", list.get(0));
		}
		else{
			js.setMessage("login error");
		}
		return js;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logoutUser.do")
	public String logoutUser(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/index.do")
	public String index(Integer id,HttpSession session){
        User u = fus.findUserById(id);
        session.setAttribute("user", u);
		return "/front/user/index";
	}
	
	@RequestMapping(value="/profile.do",method=RequestMethod.GET)
	public String profile(){
        return "/front/user/profile";
	}
	
	@RequestMapping(value="/profile.do",method=RequestMethod.POST)
	public String profile(User user,HttpSession session){
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		fus.updateUser(user);
        return "redirect:/front/user/index.do?id="+user.getId();
	}
	
	@RequestMapping(value="/avatar.do",method=RequestMethod.GET)
	public String avatar(){
        return "/front/user/avatar";
	}
	
	@RequestMapping(value="/avatar.do",method=RequestMethod.POST)
	public String avatar(User u,MultipartFile image_file, HttpSession session) throws Exception{
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = FilenameUtils.getExtension(image_file.getOriginalFilename());
        String fileName = name+"."+extension;
        u.setHeadUrl(fileName);
        fus.updateImg(u);
        String path = "D:\\upload";
        image_file.transferTo(new File(path+"\\"+fileName));
        User user = fus.findUserById(u.getId());
        session.setAttribute("user", user);
		return "redirect:/front/user/index.do?id="+user.getId();
	}
	
	@RequestMapping(value="/password.do",method=RequestMethod.GET)
	public String password(){
        return "/front/user/password";
	}
	
	@RequestMapping(value="/password.do",method=RequestMethod.POST)
	public String password(User u,HttpSession session){
        fus.updatePwd(u);
        session.invalidate();
        return "redirect:/front/user/logout.do";
	}
	
	@RequestMapping("/passwordJuge.do")
	@ResponseBody
	public String passwordJuge(User u){
		String pwd = fus.findPwdById(u.getId());
		if(pwd.equals(u.getPassword())){
			return "0";
		}else{
			return "1";
		}
	}
	
	@RequestMapping(value="/forgetpwd.do",method=RequestMethod.GET)
	public String forgetpwd(){
        return "/front/user/forget_pwd";
	}
	
	@RequestMapping(value="/forgetpwd.do",method=RequestMethod.POST)
	public String forgetpwd(User u,Model md){
		List<User> user = fus.findUserByMailAndCap(u);
		if(user.size() != 0){
			md.addAttribute("user", user.get(0));
			return "/front/user/reset_pwd";
		}else{
			md.addAttribute("result", 1);
			md.addAttribute("email", u.getEmail());
			return "/front/user/forget_pwd";
		}
	}
	
	@RequestMapping("/sendemail.do")
	@ResponseBody
	public Json sendemail(String email) {
		Json js = new Json();
		List<User> u = fus.findUserByMail(email);
		if(u.size() != 0){
			fus.updateYzm(u.get(0));
			js.setSuccess(true);
		}else{
			js.setSuccess(false);
			js.setMessage("email is error");
		}
		return js;
	}
	
	@RequestMapping(value="/resetpwd.do",method=RequestMethod.POST)
	public String resetpwd(User u){
		fus.updatePwd(u);
		return "redirect:/front/user/logout.do";
	}

}
