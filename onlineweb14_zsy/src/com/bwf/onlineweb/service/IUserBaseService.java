package com.bwf.onlineweb.service;

import java.util.List;

import com.bwf.onlineweb.entity.UserBase;
import com.bwf.onlineweb.vo.ApplyedCourse;

public interface IUserBaseService {

	
	
	/**
	 * 注册用户
	 * @param userBase
	 * @return 0:未保存成功；1：保存成功；2：已存在
	 */
	public int reg(UserBase userBase);
	
	/**
	 * 用户注册
	 * @param account账号
	 * @param pwd密码
	 * @return
	 */
	public UserBase login(String account,String pwd);
	
	/**
	 * 申请课程
	 * @param account  帐号
	 * @param courseId 课程ID
	 * @return
	 */
//	public int applyCourse(String account,int courseId);
	public List<ApplyedCourse> applyCourse(String account,int courseId);
	
}
