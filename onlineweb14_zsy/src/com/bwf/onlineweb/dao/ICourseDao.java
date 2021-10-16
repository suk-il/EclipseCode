package com.bwf.onlineweb.dao;

import java.util.List;

import com.bwf.onlineweb.entity.Course;
//Dao是简单的对数据库进行增删改查

/**
 *课程信息的接�?
 * @author admin
 *
 */
public interface ICourseDao {

	/**
	 * 获取已经有的课程
	 * @return
	 */
	public List<Course> findAll();
	
	/**
	 * 把数据库的课程列表信息封装到course对象
	 * 根据课程编号，查询课程详细信息
	 * @param id
	 * @return
	 */
	public Course findById(int id);
	/**
	 * 根据课程名字查找
	 * @param name 课程名
	 * @return
	 */
	public List<Course> findByName(String name);
	
}
