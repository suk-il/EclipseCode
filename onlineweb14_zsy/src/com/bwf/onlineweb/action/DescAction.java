package com.bwf.onlineweb.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwf.onlineweb.entity.Course;
import com.bwf.onlineweb.service.ICourseService;
import com.bwf.onlineweb.service.impl.CourseService;

public class DescAction extends HttpServlet {
	private ICourseService courseService = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 接收请求参数
		String id = req.getParameter("id");

		// 调用业务逻辑
		Course course = courseService.detail(Integer.parseInt(id));

		// 封装页面上所需数据
		req.setAttribute("course", course);
		// 页面的跳转
		req.getRequestDispatcher("WEB-INF/pages/desc.jsp").forward(req,resp);

	}

}
