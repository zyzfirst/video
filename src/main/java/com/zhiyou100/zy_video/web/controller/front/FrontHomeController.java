package com.zhiyou100.zy_video.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FrontHomeController {
	
	@RequestMapping("/index.do")
	public String home(){
		return "/front/index";
	}

}
