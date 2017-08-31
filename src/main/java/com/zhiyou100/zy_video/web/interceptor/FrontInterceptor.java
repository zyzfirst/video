package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy_video.model.User;

public class FrontInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest res, HttpServletResponse req, Object arg2) throws Exception {
		boolean result = true;
		User user = (User)res.getSession().getAttribute("_front_user");
		if(user == null){
			req.sendRedirect(res.getContextPath()+"/index.jsp");
			result = false;
		}
		
		
		return result;
	}

}
