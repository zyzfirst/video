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
<script type="text/javascript">
var courseName = null;
var playTimes = null;
function statisticRe(){
	
	$.get(
		"${pageContext.request.contextPath}/statistic/statisticAjax.action",	
	    function(data){
			alert(data);
			courseName=data.courseName;
			alert(courseName);
			playTimes = data.playTimes;
			alert(playTimes);
			
			require
			.config({
				paths : {
					echarts : '${pageContext.request.contextPath}/echarts/build/dist'
				}
			});
			
			require([ 'echarts', 'echarts/chart/bar' 
				], function(ec) {
				// 基于准备好的dom，初始化echarts图表
				var myChart = ec.init(document.getElementById('mainTwo'));

				var option = {
					
						title: {
			                text: '数据来源:zhiyou100.com',
			                textStyle: {
			    	        	fontWeight: '10px',              
			    	        	
			    	      	},
			                x:"center" ,
			                subtext:'课程平均播放次数'
			                
			            },
						tooltip : {
						show : true
					},
					legend : {
						data : [ '课程平均播放次数' ],
						y:'bottom'
					},
					yAxis : [ {
						type : 'category',
						data : courseName
					} ],
					xAxis : [ {
						type : 'value'
					} ],
					series : [ {
						"name" : "播放次数",
						"type" : "bar",
						"data" : playTimes
					} ]
				};

				// 为echarts对象加载数据 
				myChart.setOption(option);
			});
			
		},
	     "json"
	);
	
	

	
}
</script>
</head>
<body>

	<jsp:include page="/header.jsp">
		<jsp:param value="statistic" name="fromJsp" />
	</jsp:include>
	<div class="container">
		<div class="jumbotron" style="padding-left: 30px;">
			<p style="font-size: 32px;">统计-统计列表</p>
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
					data : ${courseName}
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
		alert(${avgTimes});
		alert(${courseName});
		
	});
	</script>
		<input type="button" value="ajax加载表" onclick="statisticRe()">
		<div id="mainTwo" style="height: 600px"></div>
	</div>
</body>
</html>