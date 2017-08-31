package com.zhiyou100.zy_video.utils;



public class DateUtil {
	
	public static String dataFormate(Integer i){
		String str = null;
		int a = i/60;
		if(a<10){
			if(i%60<10){
				str = "00:"+"0"+a+":0"+i%60;
			}else{
				str = "00:"+"0"+a+":"+i%60;
			}
		}else{
			if(i%60<10){
				str ="00:"+ a+":0"+i%60;
			}else{
				str = "00:"+a+":"+i%60;
			}
		}
		return str;
		
	}

}
