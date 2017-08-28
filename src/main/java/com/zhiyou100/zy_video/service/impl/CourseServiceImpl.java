package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.CourseService;
import com.zhiyou100.zy_video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper cm;

	@Override
	public Page<Course> findAllCourse(Integer page) {
		Page<Course> course = new Page<>();
		course.setSize(10);
		course.setPage(page);
		course.setTotal(cm.findCourseCount());
		course.setRows(cm.findAllCourseByPage((page-1)*5));
		return course;
	}

	@Override
	public void deleteCourse(Integer id) {
		cm.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Subject> findSubject() {
		return cm.findSubject();
	}

	@Override
	public void addCourse(Course course) {
		cm.insertSelective(course);
		
	}

	@Override
	public Course findCourseById(Integer id) {
		
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updateCourse(Course course) {
		cm.updateByPrimaryKeySelective(course);
		
	}

}
