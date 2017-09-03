package com.zhiyou100.zy_video.web.controller.front;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
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
import com.zhiyou100.zy_video.utils.PictureUtil;
@Controller
@RequestMapping("/front/user")
public class UserController {
	
	@Autowired
	FrontUserService fus;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public Json regist(User user,Model md){
		Json js = new Json();
		boolean result = fus.isRegistUser(user);
		if(result){
			js.setSuccess(true);
			md.addAttribute("email", user.getEmail());
		}else{
			js.setSuccess(false);
			js.setMessage("regist error");
		}
		return js;
	}
	
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Json login(User user,HttpSession session){
		Json js = new Json();
		List<User> list = fus.findUserByMailAndPwd(user);
		if(!list.isEmpty()){
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
		session.removeAttribute("_front_user");;
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logoutUser.do")
	public String logoutUser(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/index.do";
	}
	
	@RequestMapping("/index.do")
	public String index(Model md,HttpSession session){
		resetSessionAndModel(session, md);
		return "/front/user/index";
	}
	
	@RequestMapping(value="/profile.do",method=RequestMethod.GET)
	public String profile(Model md,HttpSession session){
		resetSessionAndModel(session, md);
        return "/front/user/profile";
	}
	
	@RequestMapping(value="/profile.do",method=RequestMethod.POST)
	public String profile(User user){
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		fus.updateUser(user);
        return "redirect:/front/user/index.do";
	}
	
	@RequestMapping(value="/avatar.do",method=RequestMethod.GET)
	public String avatar(Model md,HttpSession session){
		resetSessionAndModel(session, md);
        return "/front/user/avatar";
	}
	
	@RequestMapping(value="/avatar.do",method=RequestMethod.POST)
	public String avatar(User u,MultipartFile image_file, HttpSession session) throws Exception{
        
        u.setHeadUrl(PictureUtil.getFileUrl(image_file.getOriginalFilename()));
        fus.updateImg(u);
        image_file.transferTo(PictureUtil.getFilePath(image_file.getOriginalFilename()));
        User user = fus.findUserById(u.getId());
        session.setAttribute("user", user);
		return "redirect:/front/user/index.do";
	}
	
	@RequestMapping(value="/password.do",method=RequestMethod.GET)
	public String password(Model md,HttpSession session){
		resetSessionAndModel(session, md);
        return "/front/user/password";
	}
	
	@RequestMapping(value="/password.do",method=RequestMethod.POST)
	public String password(User u,Model md){
		String pwd = fus.findPwdById(u.getId());
		if(pwd.equals(u.getPassword())){
			fus.updatePwd(u);
			return "redirect:/front/user/logout.do";
		}else{
			md.addAttribute("message", "原始密码有误");
			return "/front/user/password";
		}
		
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
			return "/front/user/forget_pwd";
		}
	}
	
	@RequestMapping("/sendemail.do")
	@ResponseBody
	public Json sendemail(String email) {
		Json js = new Json();
		List<User> u = fus.findUserByMail(email);
		if(!u.isEmpty()){
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
	private void resetSessionAndModel(HttpSession session,Model md){
		User user = (User)session.getAttribute("_front_user");
		User newUser = fus.findUserBySessionUser(user);
		session.setAttribute("_front_user", newUser);
		if(md != null){
			md.addAttribute("user", newUser);
		}
	}

}
