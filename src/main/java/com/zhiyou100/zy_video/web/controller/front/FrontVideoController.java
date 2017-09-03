package com.zhiyou100.zy_video.web.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.FrontCourseService;
import com.zhiyou100.zy_video.service.FrontVideoService;
import com.zhiyou100.zy_video.utils.DateUtil;

@Controller
@RequestMapping("/front/video")
public class FrontVideoController {
	@Autowired
	FrontVideoService fvs;
	@Autowired
	FrontCourseService fcs;
	
	
	@RequestMapping("/index.do")
	public String index(Integer videoId,Integer subjectId,Model md){
		Video video = fvs.findVideoById(videoId);
		md.addAttribute("video", video);
		Subject subject = fcs.findSubjectById(subjectId);
		md.addAttribute("subject", subject);
		return "/front/video/index";
	}
	
	@RequestMapping("/state.do")
	public void state(Integer videoId){
		Video v = fvs.getVideoById(videoId);
		v.setVideoPlayTimes(v.getVideoPlayTimes()+1);
		fvs.updateTimes(v);
	}
	
	@RequestMapping("/videoData.do")
	public String videoData(Integer videoId,Integer subjectId,Model md){
		Video video = fvs.findVideoById(videoId);
		md.addAttribute("video", video);
		Subject subject = fcs.findSubjectById(subjectId);
		md.addAttribute("subject", subject);
		
		List<Video> list = fvs.findVideoBySubjectId(subjectId,video.getCourseId());
		
		md.addAttribute("list", list);
		return "/front/video/content";
	}

}
