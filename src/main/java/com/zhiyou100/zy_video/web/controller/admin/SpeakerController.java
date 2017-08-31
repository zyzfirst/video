package com.zhiyou100.zy_video.web.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.service.SpeakerService;
import com.zhiyou100.zy_video.utils.Page;

@Controller
@RequestMapping("/admin/speaker")
public class SpeakerController {
	
	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speaker.action")
	public String videoList(Model md,
			                @RequestParam(defaultValue="")String speaker_name,
			                @RequestParam(defaultValue="")String speaker_job,
			                @RequestParam(defaultValue="1")Integer page){
		Page<Speaker> list= ss.findAllSpeakerBySerch(speaker_name,speaker_job,page);
		md.addAttribute("speaker_name", speaker_name);
		md.addAttribute("speaker_job", speaker_job);
		md.addAttribute("page", list);
		return "/admin/speaker/speaker";
	}
	
	/*@RequestMapping("/deleteSpeaker.action")
	public String deleteSpeaker(Integer id){
		ss.deleteSpeaker(id);
		return "redirect:/speaker/speaker.action";
	}*/
	
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.GET)
	public String addSpeaker(){
		return "/admin/speaker/addSpeaker";
	}
	
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.POST)
	public String addSpeaker(Speaker speaker){
		ss.addSpeaker(speaker);
		return "redirect:/admin/speaker/speaker.action";
	}
	
	@RequestMapping(value="/updateSpeaker.action",method=RequestMethod.GET)
	public String updateSpeaker(Integer id,Model md){
		Speaker speaker = ss.findSpeakerById(id);
		md.addAttribute("list", speaker);
		return "/admin/speaker/updateSpeaker";
	}
	
	@RequestMapping(value="/updateSpeaker.action",method=RequestMethod.POST)
	public String updateSpeaker(Speaker speaker){
		ss.updateSpeaker(speaker);
		return "redirect:/admin/speaker/speaker.action";
	}
	
	@RequestMapping("/deleteSpeaker.action")
	@ResponseBody
	public String deleteSpeaker(Integer id){
		ss.deleteSpeaker(id);
		return "success";
	}

}
