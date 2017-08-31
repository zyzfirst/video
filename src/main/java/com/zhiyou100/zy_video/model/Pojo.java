package com.zhiyou100.zy_video.model;

import java.util.List;

public class Pojo {
	private List<Course> course;
	private Subject subject;
	private Speaker speaker;
	private List<Video> video;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<Video> getVideo() {
		return video;
	}
	public void setVideo(List<Video> video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Pojo [course=" + course + ", subject=" + subject + ", speaker=" + speaker + ", video=" + video + "]";
	}
	
}
