<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>搜索页面</title>


</head>
<body>
	<%@include file="nav.jsp" %>
	<div class="container">
		<table id="tb1" class="searchtb">
			<thead>
				<tr>
					<th>图片</th>
					<th>课程名</th>
					<th>价格</th>
					<th>开班时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${courseList } " var ="course">
					<tr>
						<td><img src="img/${course.img}" /></td>
						<td><a href="desc.do?id=${course.id}">${course.name}</a></td>
						<td>${course.price}</td>
						<td>${course.startData}</td>
						<td><a href="apply.html">申请</a></td>
					</tr>
				</c:forEach>
			</tbody>



		</table>

	</div>
</body>
</html>
