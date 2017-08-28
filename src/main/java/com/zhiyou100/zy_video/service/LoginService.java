package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Admin;

public interface LoginService {

	List<Admin> getAdmin(String login_name, String login_pwd);

}
