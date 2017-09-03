package com.zhiyou100.zy_video.utils;



public class DateUtil {
	
	public static String dataFormate(Integer videoLength){
		Integer hour = videoLength / 3600;
    	Integer min =  videoLength % 3600 / 60;
    	Integer sec = videoLength % 60;
		return String.format("%02d : %02d : %02d", hour,min,sec);
		
	}
	public static void main(String[] args) {
		System.out.println(dataFormate(68));
		
	}
	
	

}
