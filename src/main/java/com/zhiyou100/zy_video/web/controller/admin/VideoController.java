package com.zhiyou100.zy_video.web.controller.admin;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.VideoService;
import com.zhiyou100.zy_video.utils.Page;

@Controller
@RequestMapping("/admin/video")
public class VideoController {

	@Autowired
	VideoService vs;
	@RequestMapping("/video.action")
	public String videoList(Model md,Integer speaker_id,Integer course_id,
			                @RequestParam(defaultValue="")String video_title,
			                @RequestParam(defaultValue="1")Integer page){
		Page<Video> list= vs.findAllVideoBySerch(speaker_id,course_id,video_title,page);
		List<Speaker> speaker= vs.findAllSpeaker();
		List<Course> course= vs.findAllCourse();
		md.addAttribute("title", video_title);
		md.addAttribute("sid", speaker_id);
		md.addAttribute("cid", course_id);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("page", list);
		return "/admin/video/video";
	}
	
	@RequestMapping("/deleteVideo.action")
	@ResponseBody
	public String deleteVideo(Integer id){
		vs.deleteVideo(id);
		return "success";
	}
	
	@RequestMapping(value= "/addVideo.action",method=RequestMethod.GET)
	public String addVideo(Model md){
		List<Speaker> speaker= vs.findAllSpeaker();
		List<Course> course= vs.findAllCourse();
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		return "/admin/video/addVideo";
	}
	
	@RequestMapping(value= "/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video video){
		video.setInsertTime(new Timestamp(System.currentTimeMillis()));
		video.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		video.setVideoPlayTimes(0);
		vs.addVideo(video);
		return "redirect:/admin/video/video.action";
	}
	
	@RequestMapping(value= "/updateVideo.action",method=RequestMethod.GET)
	public String updateVideo(Integer id,Model md){
		Video video = vs.findVideoById(id);
		List<Speaker> speaker= vs.findAllSpeaker();
		List<Course> course= vs.findAllCourse();
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("list", video);
		return "/admin/video/updateVideo";
	}
	
	@RequestMapping(value= "/updateVideo.action",method=RequestMethod.POST)
	public String updateVideo(Video video){
		video.setInsertTime(new Timestamp(System.currentTimeMillis()));
		video.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		video.setVideoPlayTimes(0);
		vs.updateVideo(video);
		return "redirect:/admin/video/video.action";
	}
	
	@RequestMapping("/multiDeleteVideo.action")
	public String multiDeleteVideo(Integer[] check){
		vs.multiDeleteVideo(check);
		return "redirect:/admin/video/video.action";
	}
}
