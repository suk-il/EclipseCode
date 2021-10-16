<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户登录</title>
	
		<script>
			function login(){
				var account=document.getElementById("account").value;
				var pwd=document.getElementById("pwd").value;
				var user=getUser(account,pwd);
				
				if (user==null){
					alert("账号密码不一致")
					
					
				}else{
					alert("登录成功！")
					// sessionStorage.setItem("user",JSON.stringify(user));
					
					document.cookie="user="+JSON.stringify(user);
					
					location.href="index.html";
					// 把登录的信息需要保存到cookie中
				}
			}
			
		</script>


	</head>
	<body>
		<%@include file="nav.jsp" %>

		<div class="container">
			<div class="loginreg">
				<fieldset>
					<legend>免费注册</legend>
					<table>
						<tbody>
							<tr>
								<td>账号</td>
								<td><input id="account" /></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><input type="password" id="pwd" /></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button type="submit" onclick="login()">确 定</button><a href="reg.html" target="_blank">还没有账号，去注册</a>
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>

	</body>
</html>
