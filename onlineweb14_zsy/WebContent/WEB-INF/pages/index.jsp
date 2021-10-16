<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>在线报名系统主页</title>
<link href="css/gloabl.css" rel="stylesheet" type="text/css" />
<script src="js/global.js"></script>
<script>
	
	// 退出登录
	function logOut() {
		var date = new Date("1970-1-1");
		date = date.toGMTString();
		document.cookie = "user=0;expires=" + date;
		location.href = "index.html";
	}

	function applyCourse(id) {
		var flag = saveApply(id);
		if (!flag) {
			alert("请先登录！");
			location.href = "login.html";
		} else {
			location.href = "apply.html"
		}
	}
</script>
</head>
<body>
	
<%@include file="nav.jsp" %>	
	<div class="container">
		<div class="courseList">

			<c:forEach items="${courseList }" var="course">

				<!-- 每个课程 -->
				<div>
					<img src="img/${course.img }" />
					<ul>
						<li><a href="desc.do?id=${course.id }" target="_blank">${course.name }</a></li>
						<li>价格： <span>${course.price }</span></li>
						<!-- 使用格式化日期 -->
						<li>开班时间：<fmt:formatDate value="${course.startDate }"
								pattern="yyyy年MM月dd日" /></li>
						<li><a href="javascript:void(0)" onclick="applyCourse(1)">申请</a></li>
					</ul>
				</div>
				<!-- 课程结束end -->
			</c:forEach>
		</div>
	</div>
	<hr />
	<div class="foot">
		版权所有© 博为峰 <a href="#">后台管理</a>
	</div>
</body>
</html>
