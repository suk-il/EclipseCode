<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户注册</title>	

	</head>
	<body>
		<%@include file="nav.jsp" %>
		<div class="container">
		
			<div class="loginreg">
				<fieldset>
					<legend>免费注册</legend>
					<form action="reg.do" method="post">
					<table>
						<tbody>
							<tr>
								<td>账号</td>
								<td><input id="account"  name="account"/></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><input id="pwd" type="password" name="pwd"/></td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input id="name" name="name" /></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><input name="sex" type="radio" checked="checked">男 <input name="sex" type="radio" />女</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button type="submit" >确 定</button><a href="loginUI.do" target="_blank">已有账号，直接登录</a>
								</td>
							</tr>
						</tbody>
					</table>
					</form>
				</fieldset>
			</div>
		</div>
	</body>
</html>
