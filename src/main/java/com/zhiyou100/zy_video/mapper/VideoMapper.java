package com.zhiyou100.zy_video.mapper;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Pojo;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;

import java.lang.reflect.Array;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
   
    List<Video> findAllVideo();

	List<Speaker> findAllSpeaker();

	List<Course> findAllCourse();

	List<Video> findAllVideoBySerch(@Param("speaker_id") Integer speaker_id, @Param("course_id") Integer course_id,@Param("video_title") String video_title);

	int findVideoCount(@Param("speaker_id")Integer speaker_id,@Param("course_id") Integer course_id,@Param("video_title") String video_title);

	List<Video> findAllVideoByPage(@Param("speaker_id")Integer speaker_id,@Param("course_id") Integer course_id,@Param("video_title") String video_title,@Param("star") int i);

	void multiDeleteVideo(Integer[] idArr);

	List<Video> getStatistic();

	Video findVideoById(@Param("id") Integer videoId);

	Pojo findVideoListBySubjectId(@Param("id") Integer subjectId);

	List<Video> findVideoBySubjectId(@Param("id")Integer subjectId,@Param("courseId") Integer courseId);

}