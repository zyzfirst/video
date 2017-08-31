package com.zhiyou100.zy_video.web.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.FrontCourseService;

@Controller
@RequestMapping("/front/course")
public class FrontCourseController {
	@Autowired
	FrontCourseService fvs;
	
	@RequestMapping("/index.do")
	public String index(Integer subjectId,Model md){
		Subject sub = fvs.findSubjectById(subjectId);
		List<Course> course = fvs.findCourseById(subjectId);
		/*Pojo pojo = fvs.findVideoAndCourseAndSubjectById(subjectId);
		System.out.println(pojo.getSubject());
		System.out.println(pojo.getCourse());*/
		md.addAttribute("course", course);
		md.addAttribute("subject", sub);
		return "/front/course/index";
	}

	
}
