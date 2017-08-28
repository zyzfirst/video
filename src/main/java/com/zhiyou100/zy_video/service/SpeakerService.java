package com.zhiyou100.zy_video.service;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.utils.Page;

public interface SpeakerService {

	Page<Speaker> findAllSpeakerBySerch(String speaker_name, String speaker_job, Integer page);

	void deleteSpeaker(Integer id);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(Integer id);

	void updateSpeaker(Speaker speaker);


}
