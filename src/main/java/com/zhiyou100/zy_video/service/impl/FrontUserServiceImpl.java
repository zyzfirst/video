package com.zhiyou100.zy_video.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.UserMapper;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.model.UserExample;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.utils.MailUtil;
@Service
public class FrontUserServiceImpl implements FrontUserService {
	@Autowired
	UserMapper um;

	@Override
	public int regist(User user) {
		return um.insertSelective(user);
		
	}

	@Override
	public List<User> findUserByMail(User user) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail());
		return um.selectByExample(ue);
	}

	@Override
	public List<User> findUserByMailAndPwd(User user) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());
		return um.selectByExample(ue);
	}

	@Override
	public User findUserById(Integer id) {
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(User user) {
		um.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public void updateImg(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public void updatePwd(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public String findPwdById(Integer id) {
		return um.findPwdById(id);
	}

	@Override
	public List<User> findUserByMail(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		return um.selectByExample(ue);
	}

	@Override
	public void updateYzm(User u) {
		int a  =new Random().nextInt(99999-10000);
		String str = "" + (a+10000);
		try {
			MailUtil.send(u.getEmail(), "验证码", str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		u.setCaptcha(str);
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public List<User> findUserByMailAndCap(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		return um.selectByExample(ue);
	}

}
