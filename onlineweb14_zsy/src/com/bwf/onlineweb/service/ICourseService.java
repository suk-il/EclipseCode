package com.bwf.onlineweb.service;

import java.util.List;

import com.bwf.onlineweb.entity.Course;

/**
 * 这是个接口
 * 课程业务处理
 * @author admin
 *
 */
public interface ICourseService {

	/**
	 * 得到已有的课程
	 * @return
	 */
	public List<Course> getAll();
	
	/**
	 * 根据编号获取课程详细信息
	 * @param id 课程编号
	 * @return 课程信息
	 */
	public Course detail(int id);
	
	
	/**
	 * 根据关键字搜索课程信息
	 * @param keyWord 关键字
	 * @return 课程数据
	 */
	public List<Course> getByKeyWord(String keyWord);
	
	
}
