package com.zhiyou100.zy_video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SpeakerMapper;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.service.SpeakerService;
import com.zhiyou100.zy_video.utils.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	SpeakerMapper sm;

	@Override
	public Page<Speaker> findAllSpeakerBySerch(String speaker_name, String speaker_job, Integer page) {
		Page<Speaker> pageInfo = new Page<>();
		pageInfo.setSize(10);
		pageInfo.setPage(page);
		pageInfo.setTotal(sm.findSpeakerCount(speaker_name,speaker_job));
		pageInfo.setRows(sm.findAllSpeakerByPage(speaker_name,speaker_job,(page-1)*10));
		return pageInfo;
	}

	@Override
	public void deleteSpeaker(Integer id) {
		sm.deleteByPrimaryKey(id);
		
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insertSelective(speaker);
		
	}

	@Override
	public Speaker findSpeakerById(Integer id) {
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		sm.updateByPrimaryKeySelective(speaker);
		
	}

}
