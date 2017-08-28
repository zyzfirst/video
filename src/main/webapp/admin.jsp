<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>视频管理系统</title>

		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		
	</head>

	<body>

		<nav class="navbar navbar-inverse navbar-static-top" style="margin-bottom: 0px;">
			<div class="container">
				<div>
					<a class="navbar-brand" target="pageBox" href="addTeacher.html" style="font-size: 25px;">视频管理系统</a>
					<a class="navbar-brand" target="pageBox" href="${pageContext.request.contextPath}/video/video.action">视频管理</a>
					<a class="navbar-brand" target="pageBox" href="${pageContext.request.contextPath}/speaker/speaker.action">主讲人管理</a>
					<a class="navbar-brand" target="pageBox" href="${pageContext.request.contextPath}/course/course.action">课程管理</a>
					<a class="navbar-brand" target="pageBox" href="${pageContext.request.contextPath}/statistic/statistic.action">统计分析</a>
				</div>
				<div class="pull-right">
					<a class="navbar-brand" target="pageBox" href="#">${admin.loginName }</a>
					<a class="glyphicon glyphicon-log-out navbar-brand" target="pageBox" href="#"></a>
				</div>
			</div>
		</nav>
		<div class="embed-responsive embed-responsive-16by9" style="margin-right: 20%;margin-left: 20%;">
			<iframe class="embed-responsive-item" src="" name="pageBox" ></iframe>
	    </div>
	</body>
</html>