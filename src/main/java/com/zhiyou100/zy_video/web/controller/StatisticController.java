package com.zhiyou100.zy_video.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.VideoService;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	@Autowired
	VideoService vs;
	
	@RequestMapping("/statistic.action")
	public String statistic(Model md){
		List<Video> list = vs.getStatistic();
		
		StringBuilder times = new StringBuilder();
		times.append("["+list.get(0).getAvgTimes());
		for(int a= 1;a<list.size();a++){
			times.append(","+list.get(a).getAvgTimes());
		}
		times.append("]");
		
		StringBuilder sb = new StringBuilder();
		sb.append("[\""+list.get(0).getCourseName()+"\"");
		for(int a= 1;a<list.size();a++){
			sb.append(",\""+list.get(a).getCourseName()+"\"");
		}
		sb.append("]");

		md.addAttribute("avgTimes", times);
		md.addAttribute("courseName", sb);
		return "/statistic/statistic";
	}

}
