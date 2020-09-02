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
					        	<c:forEach var="a" items="${chooselist}">	
					        		<c:if test="${a.tno==c.tno}">
										 <tr>
								             <td>${c.tname}</td>
								             <td>${c.sex}</td>
								             <td>${c.title}</td>
								             <td>${c.discipline}</td>
								             <td>${c.email}</td>
								             <td>${c.intro}</td>
								             <td>
												<c:if test="${a.status==0}">
													已选
												</c:if>

								             </td>
								             <td>
												  	<a href="../student.action?func=退选&Tno=${c.tno}"><button class="btn btn-warning" >退选</button></a>

								             </td>
								           </tr>		
									</c:if>
					       		</c:forEach>
					        </c:forEach>
				        </tbody>
					</table>
				
			</div>
	</body>
</html>