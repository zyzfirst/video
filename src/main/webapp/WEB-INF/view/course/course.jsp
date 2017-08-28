<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zyz" uri="http://zhiyou100.com/common/"%>
<%@include file="/modal.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>视频管理系统</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function deleteCourse(the) {
		$("#url").val(the.name);
		$('#deleteModal').modal();
	}
</script>

</head>

<body>

	<div class=" jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">课程列表-课程管理</p>
	</div>
	<div>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/course/addCourse.action"
			role="button">添加课程</a>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>标题</th>
					<th>学科</th>
					<th width="70%">简介</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.rows }" varStatus="status" var="li">
					<tr>
						<th scope="row">${status.count }</th>
						<td>${li.courseName }</td>
						<td>${li.sub.subjectName }</td>
						<td>${li.courseDescr }</td>
						<td><a class="glyphicon glyphicon-edit"
							href="${pageContext.request.contextPath}/course/updateCourse.action?id=${li.id}"></a></td>
						<td><a class="glyphicon glyphicon-trash"
							onclick="deleteCourse(this)" 
							name="${pageContext.request.contextPath}/course/deleteCourse.action?id=${li.id}"></a>
							</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<zyz:page
			url="${pageContext.request.contextPath}/course/course.action"></zyz:page>
		<%@include file="/modal.jsp"%>
	</div>

</body>

</html>