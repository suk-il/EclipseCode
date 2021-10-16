package com.bwf.onlineweb.dao;

import java.util.List;

import com.bwf.onlineweb.entity.UserBase;
import com.bwf.onlineweb.vo.ApplyedCourse;

/**
 * 接口
 * @author admin
 *
 */
public interface IUserBaseDao {

	/**
	 * 保存用户
	 * @param userBase
	 * @return
	 */
	public int save(UserBase userBase);
	
	/**
	 * 根据账号得到用户信息
	 * @param account
	 * @return
	 */
	public UserBase findByAccount(String account);
	
	/**
	 * 根据账号和密码得到用户信息
	 * @param account 账号
	 * @param pwd 密码
	 * @return
	 */
	public UserBase findBy(String account,String pwd);
	
	/**
	 * 申请课程
	 * @param account帐号
	 * @param courseId课程编号
	 * @return
	 */
	public int saveMyCourse(String account,int courseId);
	
	
	/**
	 * 根据账号获取已申请的课程
	 * @param account  帐号
	 * @return
	 */
	public List<ApplyedCourse> findMyApplyed(String account); 
	
}
