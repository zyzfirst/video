package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.User;

public interface FrontUserService {

	int regist(User user);

	List<User> findUserByMail(User user);

	List<User> findUserByMailAndPwd(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void updateImg(User u);

	void updatePwd(User u);

	String findPwdById(Integer id);

	List<User> findUserByMail(String email);

	void updateYzm(User u);

	List<User> findUserByMailAndCap(User u);

	boolean isRegistUser(User user);

	User findUserBySessionUser(User user);

}
