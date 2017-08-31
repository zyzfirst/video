package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.FrontVideoService;
@Service
public class FrontVideoServiceImpl implements FrontVideoService {
	@Autowired
	VideoMapper vm;

	@Override
	public Video findVideoById(Integer videoId) {
		return vm.findVideoById(videoId);
	}

	@Override
	public Pojo findVideoListBySubjectId(Integer subjectId) {
		
		return vm.findVideoListBySubjectId(subjectId);
	}

	@Override
	public List<Video> findVideoBySubjectId(Integer subjectId,Integer courseId) {
		return vm.findVideoBySubjectId(subjectId,courseId);
	}

	@Override
	public Video getVideoById(Integer videoId) {
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public void updateTimes(Video v) {
         vm.updateByPrimaryKeySelective(v);
	}

}
