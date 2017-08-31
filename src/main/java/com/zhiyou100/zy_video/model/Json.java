package com.zhiyou100.zy_video.model;

public class Json {
	private StringBuilder courseName;
	private StringBuilder playTimes;
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
	public StringBuilder getCourseName() {
		return courseName;
	}
	public void setCourseName(StringBuilder courseName) {
		this.courseName = courseName;
	}
	public StringBuilder getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(StringBuilder playTimes) {
		this.playTimes = playTimes;
	}
	@Override
	public String toString() {
		return "Json [courseName=" + courseName + ", playTimes=" + playTimes + "]";
	}
	
}
