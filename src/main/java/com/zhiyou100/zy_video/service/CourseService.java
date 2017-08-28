package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.utils.Page;

public interface CourseService {

	Page<Course> findAllCourse(Integer page);

	void deleteCourse(Integer id);

	List<Subject> findSubject();

	void addCourse(Course course);

	Course findCourseById(Integer id);

	void updateCourse(Course course);

}
