<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>ECharts</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/echarts/build/dist/echarts.js"></script>
</head>
<body>












	<div class="jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">统计-统计列表</p>
		<input type="hidden" name="${courseName }" value="${avgTimes }">
		<input type="hidden" id="dataname" value="${courseName }">
	</div>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height: 600px"></div>
	<!-- ECharts单文件引入 -->
	<script type="text/javascript">
		$(function() {
		// 路径配置
		require
				.config({
					paths : {
						echarts : '${pageContext.request.contextPath}/echarts/build/dist'
					}
				});

		// 使用
		require([ 'echarts', 'echarts/chart/bar' 
			], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main'));

			var option = {
				
					title: {
		                text: '数据来源:zhiyou100.com',
		                textStyle: {
		    	        	fontWeight: '10px',              
		    	        	
		    	      	},
		                x:"center" ,
		                
		            },
					tooltip : {
					show : true
				},
				legend : {
					data : [ '课程平均播放次数' ],
					x:'right'
				},
				xAxis : [ {
					type : 'category',
					data : ${courseName }
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					"name" : "播放次数",
					"type" : "bar",
					"data" : ${avgTimes}
				} ]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});
		
	});
	</script>
</body>
</html>