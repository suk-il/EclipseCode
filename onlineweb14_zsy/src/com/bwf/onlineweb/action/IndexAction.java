package com.bwf.onlineweb.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwf.onlineweb.entity.Course;
import com.bwf.onlineweb.service.ICourseService;
import com.bwf.onlineweb.service.impl.CourseService;

public class IndexAction extends HttpServlet {

	
	private ICourseService courseService=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//开始接受参数，处理业务
		
		//调用业务  获取所有的课程
		List<Course> courseList= courseService.getAll();
		//封装数据到作用域中
		req.setAttribute("courseList",courseList);
		//页面跳转
		req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);
		
	}

	
}
