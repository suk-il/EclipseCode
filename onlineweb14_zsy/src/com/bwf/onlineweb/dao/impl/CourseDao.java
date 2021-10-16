package com.bwf.onlineweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwf.onlineweb.dao.ICourseDao;
import com.bwf.onlineweb.entity.Course;
import com.bwf.onlineweb.util.DBHelp;

import sun.security.action.GetIntegerAction;

/**
 * 继承BaseDao的量的定�?
 * 
 * @author admin
 *
 */
public class CourseDao extends BaseDao implements ICourseDao {

	@Override
	public List<Course> findAll() {
		List<Course> courseList=new ArrayList<Course>();
		//拿数据库连接
		conn=DBHelp.getConn();
		sql="select * from course";
		try {
			pcmd=conn.prepareStatement(sql);
			rs=pcmd.executeQuery();
			//当结果集中数据比较多时，使用while进行遍历，然后返回List
			//借此封装数据
			while(rs.next()) {
			//把rs结果集的数据封装成实体对�?
				Course course=new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
		        course.setImg(rs.getString("img"));
		        course.setPrice(rs.getFloat("price"));
		        course.setStartDate(rs.getDate("startdate"));
			    course.setDesc(rs.getString("desc"));
			    //加入集合
			    courseList.add(course);
			}
			
			return courseList;
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelp.closeConn(conn);
		}
		
		return null;
	}

	@Override
	public Course findById(int id) {
		
		//先拿取链接
		conn=DBHelp.getConn();
		sql="select * from course where id=?";
		try {
			pcmd=conn.prepareStatement(sql);
			pcmd.setInt(1, id);
			//把数据库查询的响应结果传给结果集rs
			rs=pcmd.executeQuery();
			//判断结果集，别让它出意外
			if(rs.next()) {
				//如果有，那么就封装对象
				Course course= new Course();
				course.setId(id);
				course.setName(rs.getString("name"));
				course.setImg(rs.getString("img"));
				course.setPrice(rs.getFloat("price"));
				course.setStartDate(rs.getDate("startdate"));
				course.setDesc(rs.getString("desc"));
				
				return course;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//整完之后，关闭链接
			DBHelp.closeConn(conn);
		}	
		return null;
	}

	@Override
	public List<Course> findByName(String name) {

		List<Course> courseList=new ArrayList<>();
     conn=DBHelp.getConn();
     sql="select * from course where name like ? ";
     try {
		pcmd=conn.prepareStatement(sql);
		pcmd.setString(1, "%"+name+"%");
		rs=pcmd.executeQuery();
		
		while(rs.next()) {
			
			Course course=new Course();
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
			course.setImg(rs.getString("img"));
			course.setPrice(rs.getFloat("price"));
			course.setStartDate(rs.getDate("startdate"));
			course.setDesc(rs.getString("desc"));
			
			courseList.add(course);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		DBHelp.closeConn(conn);
	}
    	
		return courseList;
	}

}
