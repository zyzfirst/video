package com.zhiyou100.zy_video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.CourseService;
import com.zhiyou100.zy_video.utils.Page;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService cs;
	@RequestMapping("/course.action")
	public String courseList(@RequestParam(defaultValue="1")Integer page,Model md){
		Page<Course> course = cs.findAllCourse(page);
		md.addAttribute("page", course);
		return "course/course";
	}
	
	/*@RequestMapping("/deleteCourse.action")
	public String deleteCourse(Integer id){
		cs.deleteCourse(id);
		return "redirect:/course/course.action";
	}*/
	
	@RequestMapping(value="/addCourse.action",method=RequestMethod.GET)
	public String addSpeaker(Model md){
		List<Subject> subject = cs.findSubject();
		md.addAttribute("subject", subject);
		return "/course/addCourse";
	}
	
	@RequestMapping(value="/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course course){
        cs.addCourse(course);
		return "redirect:/course/course.action";
	}
	
	@RequestMapping(value="/updateCourse.action",method=RequestMethod.GET)
	public String updateCourse(Model md,Integer id){
		List<Subject> subject = cs.findSubject();
		Course course= cs.findCourseById(id);
		md.addAttribute("subject", subject);
		md.addAttribute("list", course);
		return "/course/updateCourse";
	}
	
	@RequestMapping(value="/updateCourse.action",method=RequestMethod.POST)
	public String updateCourse(Course course){
		cs.updateCourse(course);
		return "redirect:/course/course.action";
	}
	
	@RequestMapping("/deleteCourse.action")
	@ResponseBody
	public String deleteCourseById(Integer id){
		cs.deleteCourse(id);
		return "success";
	}

}
