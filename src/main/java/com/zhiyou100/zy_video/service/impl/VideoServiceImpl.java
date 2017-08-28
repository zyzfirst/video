package com.zhiyou100.zy_video.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;
import com.zhiyou100.zy_video.model.VideoExample.Criteria;
import com.zhiyou100.zy_video.service.VideoService;
import com.zhiyou100.zy_video.utils.Page;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoMapper vm;

	@Override
	public List<Video> findAllVideo() {
		
		return vm.findAllVideo();
	}

	@Override
	public void deleteVideo(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Speaker> findAllSpeaker() {
		return vm.findAllSpeaker();
	}

	@Override
	public List<Course> findAllCourse() {
		return vm.findAllCourse();
	}

	@Override
	public void addVideo(Video video) {
		vm.insertSelective(video);
		
		
	}

	@Override
	public Video findVideoById(Integer id) {
		return vm.selectByPrimaryKey(id);
	}

	@Override
	public void updateVideo(Video video) {
		vm.updateByPrimaryKeySelective(video);
		
	}

	@Override
	public Page<Video> findAllVideoBySerch(Integer speaker_id, Integer course_id, String video_title,Integer page) {
		Page<Video> pageInfo = new Page<>();
		pageInfo.setSize(7);
		pageInfo.setPage(page);
		pageInfo.setTotal(vm.findVideoCount(speaker_id,course_id,video_title));
		pageInfo.setRows(vm.findAllVideoByPage(speaker_id,course_id,video_title,(page-1)*7));
		return pageInfo;
	}

	@Override
	public void multiDeleteVideo(Integer[] idArr) {
		VideoExample ve = new VideoExample();
		 ve.createCriteria().andIdIn(java.util.Arrays.asList(idArr));
		 vm.deleteByExample(ve);
		//vm.multiDeleteVideo(idArr);
		
	}

	@Override
	public List<Video> getStatistic() {
		
		return vm.getStatistic();
	}

}
