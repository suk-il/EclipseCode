package com.bwf.onlineweb.service.impl;

import java.util.List;

import com.bwf.onlineweb.dao.IUserBaseDao;
import com.bwf.onlineweb.dao.impl.UserBaseDao;
import com.bwf.onlineweb.entity.UserBase;
import com.bwf.onlineweb.service.IUserBaseService;
import com.bwf.onlineweb.util.MD5Util;
import com.bwf.onlineweb.vo.ApplyedCourse;

public class UserBaseService implements IUserBaseService {

	private IUserBaseDao userBaseDao;
	public UserBaseService() {
		
		userBaseDao=new UserBaseDao();
	}
	@Override
	public int reg(UserBase userBase) {
		
		//判断是否已经存在用户
		if (userBaseDao.findByAccount(userBase.getAccount())!=null) {
			//如果不为空，这说明已经有用户存在,返回2
			return 2;
		}
		
		//再保存之前进行加验证
		String pwd= userBase.getPwd();
		pwd=MD5Util.MD5(pwd);
		userBase.setPwd(pwd);
		
		
		//数据层操作
		int count= userBaseDao.save(userBase);
		return count;
	}
	@Override
	public UserBase login(String account, String pwd) {
		//密码加密
		pwd=MD5Util.MD5(pwd);

		UserBase userBase=userBaseDao.findBy(account, pwd);
		
		return userBase;
	}
	@Override
	public List<ApplyedCourse> applyCourse(String account, int courseId) {
		
         //先进行判断是否已经申请了课程

		
//		List<ApplyedCourse> applyedCourseList=new ArrayList<ApplyedCourse>();
		//先申请
		int count=userBaseDao.saveMyCourse(account, courseId);
		System.out.println(count);
		if(count!=0) {
			//再查找
			List<ApplyedCourse> applyedCourseList= userBaseDao.findMyApplyed(account);
			return applyedCourseList;
		}else {
			return null;
		}
		
	}
	

}
