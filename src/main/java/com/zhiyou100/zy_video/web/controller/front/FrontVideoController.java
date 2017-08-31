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
		video.setVideoLengthStr(DateUtil.dataFormate(video.getVideoLength()));
		md.addAttribute("video", video);
		/*Pojo pojo = fvs.findVideoListBySubjectId(subjectId);
		md.addAttribute("pojo", pojo);
		md.addAttribute("subjectId", subjectId);*/
		
		Subject subject = fcs.findSubjectById(subjectId);
		md.addAttribute("subject", subject);
		
		List<Video> list = fvs.findVideoBySubjectId(subjectId,video.getCourseId());
		for (Video video2 : list) {
			video2.setVideoLengthStr(DateUtil.dataFormate(video2.getVideoLength()));
		}
		md.addAttribute("list", list);
		
		
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
		video.setVideoLengthStr(DateUtil.dataFormate(video.getVideoLength()));
		md.addAttribute("video", video);
		System.out.println(video.getVideoLengthStr());
		Subject subject = fcs.findSubjectById(subjectId);
		md.addAttribute("subject", subject);
		
		List<Video> list = fvs.findVideoBySubjectId(subjectId,video.getCourseId());
		for (Video video2 : list) {
			video2.setVideoLengthStr(DateUtil.dataFormate(video2.getVideoLength()));
			System.out.println(video2.getVideoLengthStr());
		}
		md.addAttribute("list", list);
		return "/front/video/content";
	}

}
