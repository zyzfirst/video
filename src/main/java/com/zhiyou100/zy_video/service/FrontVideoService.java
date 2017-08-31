package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Video;

public interface FrontVideoService {

	Video findVideoById(Integer videoId);

	Pojo findVideoListBySubjectId(Integer subjectId);

	List<Video> findVideoBySubjectId(Integer subjectId, Integer courseId);

	Video getVideoById(Integer videoId);

	void updateTimes(Video v);

}
