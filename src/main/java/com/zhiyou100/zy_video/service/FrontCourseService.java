package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Subject;

public interface FrontCourseService {

	Pojo findVideoAndCourseAndSubjectById(Integer subjectId);

	Subject findSubjectById(Integer subjectId);

	List<Course> findCourseById(Integer subjectId);


}
