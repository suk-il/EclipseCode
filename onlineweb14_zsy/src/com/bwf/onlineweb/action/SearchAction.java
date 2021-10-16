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

public class SearchAction extends HttpServlet {

	private ICourseService courseService=new CourseService();
	
	
	//重写两个方法doget 和dopost，其中doget调用dopost方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyWord=req.getParameter("keyWord");
		
		List<Course> courselist= courseService.getByKeyWord(keyWord);
		
		req.setAttribute("courselist", courselist);
		
		req.getRequestDispatcher("WEB-INF/pages/search.jsp").forward(req,resp);
	}

	
	
}
