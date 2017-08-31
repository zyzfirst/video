package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService {
	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sm;

	@Override
	public Pojo findVideoAndCourseAndSubjectById(Integer subjectId) {
		
		return cm.findVideoAndCourseAndSubjectById(subjectId);
	}

	@Override
	public Subject findSubjectById(Integer subjectId) {
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public List<Course> findCourseById(Integer subjectId) {
		return cm.findCourseById(subjectId);
	}

	

}
