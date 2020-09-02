<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师事务中心</title>
		<link rel="stylesheet" href="../bs\css\bootstrap.css">
		<script src="../bs/js/jquery-3.5.1.min.js"></script>
		<script src="../bs/js/bootstrap.js"></script>
		<script src="../bs/js/holder.js"></script>
		<%@ include file="TeaCSS.jsp" %>			
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="TeaNAV.jsp" %>		
				<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th >序号</th>
								<th >学号</th>
								<th >姓名</th>
								<th >性别</th>
								<th >专业</th>
								<th >成绩</th>
								<th >本科所在院校</th>
								<th >选择状态</th>
								<th >操作</th>
							</tr>	
						</thead>
						<tbody>
					        <c:forEach var="c" items="${stuList}" varStatus="status">
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.sno}</td>
					             <td>${c.sname }</td>
					             <td>${c.sex}</td>
					             <td>${c.discipline}</td>
					             <td>${c.grade}</td>
					             <td>${c.school}</td>
					             <td>
					             	<c:forEach var="a" items="${chooseList}">		
											<c:if test="${a.sno==c.sno&&a.status==1}">
												已选	
											</c:if>
					             	</c:forEach>
					             </td>
					             <td>
					                <a href='../Teacher.action?func=选择&sno=${c.sno}'>选择</a>
					                <a href='../Teacher.action?func=退选&sno=${c.sno}'>退选</a>
					             </td>
					           </tr>
					       
					        </c:forEach>
				        </tbody>
					</table>
				
			</div>
		
		
		
	</body>
</html>