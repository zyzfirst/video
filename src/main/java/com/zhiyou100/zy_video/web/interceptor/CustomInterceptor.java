package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy_video.model.Admin;

public class CustomInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		Admin admin =(Admin) req.getSession().getAttribute("admin");
		boolean result = true;
		if(admin == null){
			req.getRequestDispatcher("/WEB-INF/view/admin/index.jsp").forward(req, res);
			result = false;
		}
		return result;
		
	}

}
