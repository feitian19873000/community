<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NAV元素</h1>
	<nav>
		<ul>
			<li><a href="/">首页</a></li>
			<li><a href="/">开发文档</a></li>
			<li></li>
		</ul>
	</nav>
	<article>
		<header>
			<h1>article元素</h1>
			<nav>
				<ul>
					<li><a href="#html5">html5的历史</a></li>
					<li><a href="#css3">css3的历史</a></li>
				</ul>
			</nav>
		</header>
		
		<section id="html5"> 
			<h1>HTML 5 的历史</h1>
			<p>正文</p>
		</section>
		<section id="css3">
			<h1>CSS 3 的历史</h1>
			<p>正文</p>
		</section>
		<footer>
			<p>
				<a href="/">编辑</a>|
				<a href="/">删除</a>|
				<a href="/">重命名</a>
			</p>
		</footer>
	</article>
	<div>aaa</div>
	<aside>
		<nav>
			<h2>评论</h2>
			<ul>
				<li><a href="/">erway</a></li>
				<li>aa</li>
			</ul>
		</nav>
	</aside>
	<h2>list</h2>
	<nav>
		<form action="" method="post">
			<input type="text" name="greeting" required="required" pattern="[0-9][A-Z]{3}" placeholder="请输入">
			<datalist id="greeting" style="display:visable">
				<option value="Good morning">Good morning</option>
				<option value="Hello">Hello</option>
				<option value="Good Afternoon">Good Afternoon</option>
			</datalist>
			<input type="submit" value="提交"/>
		</form>
	</nav>
	<footer>
		<p><small>版权所有:XXXXXXX</small></p>
	</footer>
</body>
</html>