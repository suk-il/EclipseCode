<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="css/gloabl.css" rel="stylesheet" type="text/css" />
<script src="js/global.js"></script>

<div class="nav">
	<div>
		<img src="img/logo.png" />
	</div>
	<ul>
		<li><a href="index.do">首页</a></li>
		<li>
			<div>
				<input id="keyWord" />
				<button>
					<a href="javascript:void(0)" onclick="mySearch()">搜索</a>
				</button>
			</div>
		</li>
	</ul>
	<ol id="loginStatus">
		<li><a href="login.jsp">登录</a></li>
		<li><a href="regUI.do">注册</a></li>
	</ol>
</div>