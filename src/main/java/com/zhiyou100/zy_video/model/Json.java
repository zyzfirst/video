package com.zhiyou100.zy_video.model;

import java.util.ArrayList;
import java.util.List;

public class Json {
	private List<String> courseName = new ArrayList<>();
	private List<Integer> playTimes = new ArrayList<>();
	private boolean success;
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getCourseName() {
		return courseName;
	}
	public void setCourseName(List<String> courseName) {
		this.courseName = courseName;
	}
	public List<Integer> getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(List<Integer> playTimes) {
		this.playTimes = playTimes;
	}
	@Override
	public String toString() {
		return "Json [courseName=" + courseName + ", playTimes=" + playTimes + "]";
	}
	
}
