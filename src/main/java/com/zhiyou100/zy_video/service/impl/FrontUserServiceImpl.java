package com.zhiyou100.zy_video.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.UserMapper;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.model.UserExample;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.utils.MailUtil;
import com.zhiyou100.zy_video.utils.RandomUtil;
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
		String str = ""+RandomUtil.getRandomNumber();
		try {
			MailUtil.send(u.getEmail(), "验证码",str);
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

	@Override
	public boolean isRegistUser(User user) {
		boolean re = false;
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail());
		if(um.selectByExample(ue).isEmpty()){
			user.setInsertTime(new Timestamp(System.currentTimeMillis()));
			um.insertSelective(user);
			re = true;
		}
		return re;
	}

	@Override
	public User findUserBySessionUser(User user) {
		return um.selectByPrimaryKey(user.getId());
	}

}
