package com.bwf.onlineweb.service.impl;

import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bwf.onlineweb.dao.ICourseDao;
import com.bwf.onlineweb.dao.impl.CourseDao;
import com.bwf.onlineweb.entity.Course;
import com.bwf.onlineweb.service.ICourseService;
import com.bwf.onlineweb.util.RedisHelp;

import redis.clients.jedis.Jedis;

public class CourseService implements ICourseService {

	private ICourseDao courseDao;

	public CourseService() {
		courseDao = new CourseDao();

	}

	@Override
	public List<Course> getAll() {

		List<Course> courseList;
		//使用缓存
		Jedis client=RedisHelp.getClient();
		//使用的是Redis中的courseList
		String courseList_r= client.get("courseList");
		if(courseList_r==null) {
			
		
		//从数据库中获取的
		 courseList = courseDao.findAll();

		for (Iterator<Course> it = courseList.iterator(); it.hasNext();) {
			Course course = it.next();
			// 得到courseList的信息都带有jpg
			course.setImg(course.getImg() + ".jpg");
		}
		//存入Redis
		client.set("courseList",JSON.toJSONString(courseList));
		

		}else {
			courseList=JSONArray.parseArray(courseList_r, Course.class)	;
		}
		return courseList;
	}

	//课程详细
	@Override
	public Course detail(int id) {

		Course course = courseDao.findById(id);
		return course;
	}

	@Override
	public List<Course> getByKeyWord(String keyWord) {
		List<Course> courseList=courseDao.findByName(keyWord);
		
		for (Iterator<Course> it = courseList.iterator(); it.hasNext();) {
			Course course = it.next();
			// 得到courseList的信息都带有jpg
			course.setImg(course.getImg() + ".jpg");
		}
		
		return courseList;
		
	}

}
