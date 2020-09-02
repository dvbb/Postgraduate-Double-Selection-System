<%@ page language="java"  import="java.util.*,dao.StudentDao,entity.Student,java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生事务中心</title>
		<link rel="stylesheet" href="../bs\css\bootstrap.css">
		<script src="../bs/js/jquery-3.5.1.min.js"></script>
		<script src="../bs/js/bootstrap.js"></script>
		<script src="../bs/js/holder.js"></script>
		
		<%@ include file="StuCSS.jsp" %>	
			
	</head>
	
	<body>
		<div id="header">
			</div> 
			<div class="container">
			
				<%@ include file="StuNAV.jsp" %>	
				
				<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="10%">教师名</th>
								<th width="5%">性别</th>
								<th width="10%">职称</th>
								<th width="10%">专业</th>
								<th width="10%">邮箱</th>
								<th width="20%">简介</th>
								<th width="15%">选择状态</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
					        <c:forEach var="c" items="${tlist}" varStatus="status">
					        
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.tname}</td>
					             <td>${c.sex}</td>
					             <td>${c.title}</td>
					             <td>${c.discipline}</td>
					             <td>${c.email}</td>
					             <td>${c.intro}</td>
					             <td>
					             	<c:forEach var="a" items="${chooselist}">		
											<c:if test="${a.tno==c.tno&&a.wish==1}">
												第一志愿
											</c:if>
											<c:if test="${a.tno==c.tno&&a.wish==2}">
												第二志愿
											</c:if>
											<c:if test="${a.tno==c.tno&&a.wish==3}">
												第三志愿
											</c:if>
					             	</c:forEach>
					             </td>
					             <td>
					               	<div class="dropdown">
									  <button class="btn btn-success dropdown-toggle" type="button" id="wish" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
									   选择<span class="caret"></span></button>
									  <ul class="dropdown-menu" aria-labelledby="wish">
									    <li><a href="../student.action?func=选择志愿&wish=1&Tno=${c.tno}">第一志愿</a></li>
									    <li><a href="../student.action?func=选择志愿&wish=2&Tno=${c.tno}">第二志愿</a></li>
									    <li><a href="../student.action?func=选择志愿&wish=3&Tno=${c.tno}">第三志愿</a></li>
									  </ul>
									  	<a href="../student.action?func=退选&Tno=${c.tno}"><button class="btn btn-warning" >退选</button></a>
									</div>
									
					             </td>
					           </tr>
					       
					        </c:forEach>
				        </tbody>
					</table>
				
			</div>
	</body>
</html>

