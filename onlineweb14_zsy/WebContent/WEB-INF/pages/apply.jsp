<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的课程申请</title>

<script>
			window.onload = function() {
				document.getElementById("loginStatus").innerHTML = getLoginStatus();
				var myApplyCourseList = getMyApplyCourse();
				var tr = ``;
				for (var myApplyCourse of myApplyCourseList) {
					tr +=
						`<tr>
				<td><img src="img/${myApplyCourse.img}" /></td>
				<td><a href="desc.html?id=${myApplyCourse.id}" target="_blank">${myApplyCourse.name}</a></td>
				<td>${myApplyCourse.flag}</td>
						</tr>`;
				}
				// 把tr节点加到表格中
				var tbody = document.getElementById("tb").lastElementChild;
				tbody.innerHTML = tr;
			}
		</script>
</head>
<body>
	<%@include file="nav.jsp" %>
	<div class="container">

		<table class="searchtb" id="tb">
			<thead>
				<tr>
					<th>图片</th>
					<th>课程名</th>
					<th>状态</th>
				</tr>

			</thead>
			<tbody>
			</tbody>
		</table>

	</div>


	<hr />
	<div class="foot">
		版 权 所 有 © 博 为 峰 <a href="#">后台管理</a>
	</div>
</body>


</html>
