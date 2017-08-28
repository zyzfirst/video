package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou100.zy_video.mapper.AdminMapper;
import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.AdminExample;
import com.zhiyou100.zy_video.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
 
	@Autowired
	AdminMapper am;
	@Override
	public List<Admin> getAdmin(String login_name, String login_pwd)  {
		String pwd = DigestUtils.md5DigestAsHex(login_pwd.getBytes());
		AdminExample ae = new AdminExample();
		 ae.createCriteria().andLoginNameEqualTo(login_name).andLoginPwdEqualTo(pwd);
		return am.selectByExample(ae);
	}

}
