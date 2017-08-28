package com.zhiyou100.zy_video.service;

import java.lang.reflect.Array;
import java.util.List;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.utils.Page;

public interface VideoService {

	List<Video> findAllVideo();

	void deleteVideo(Integer id);

	List<Speaker> findAllSpeaker();

	List<Course> findAllCourse();

	void addVideo(Video video);

	Video findVideoById(Integer id);

	void updateVideo(Video video);

	Page<Video> findAllVideoBySerch(Integer speaker_id, Integer course_id, String video_title,Integer page);

	void multiDeleteVideo(Integer[] idArr);

	List<Video> getStatistic();

}
