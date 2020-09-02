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
		
		<script type='text/javascript'>
		    function verification(){
		         var old=document.getElementById("oldpwd").value;
		         var new1=document.getElementById("newpwd").value;
		         var new2=document.getElementById("newpwd2").value;
		         var result=false;
		         if(old==""||new1==""){
					alert("密码不能为空!"); 
					return result;
				}
		        if(new1!=new2){
		        	alert("两次输入的密码必须一致"); 
					return result;
		        }
		    }
		</script>
		
		<%@ include file="StuCSS.jsp" %>		
		
	</head>
	
	<body>
		<div id="header"></div> 
			<div class="container">
			
				<%@ include file="StuNAV.jsp" %>	
				
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th width="10%">学号</th>
							<th width="10%">姓名</th>
							<th width="10%">性别</th>
							<th width="10%">成绩</th>
							<th width="10%">本科院校</th>
							<th width="10%">专业</th>
							<th width="10%">邮箱</th>
							<th width="10%">手机号</th>
							<th width="10%">学院号</th>
						</tr>
					</thead>
					<tbody>
				           <tr>
		     					<td>${user.sno}</td>
				            	<td>${user.sname}</td>
				            	<td>${user.sex}</td>
				            	<td>${user.grade}</td>
				            	<td>${user.school}</td>
				            	<td>${user.discipline}</td>
				            	<td>${user.email}</td>
				            	<td>${user.phone}</td>
				            	<td>${user.cno}</td>
		
				           </tr>
			        </tbody>
				</table>
				
				<form action="../student.action" method="get">
			   		<div class="form-group">
			   			<label>原密码:</label>
			   			<div class="input-group">
					      <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
					      <input type="password" class="form-control" name="oldpwd" id="oldpwd">
					    </div>
			   		</div>
			   		<div class="form-group">
			   			<label>新密码:</label>
			   			<div class="input-group">
					      <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
					      <input type="password" class="form-control" name="newpwd" id="newpwd">
					    </div>
			   		</div>
			   		<div class="form-group">
			   			<label>再次输入新密码:</label>
			   			<div class="input-group">
					      <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
					      <input type="password" class="form-control" name="newpwd2" id="newpwd2">
					    </div>
			   		</div>
			   		<div class="form-group">
			   			<button type="submit" class="btn btn-success" onclick="verification()">确认更新</button>
			   			<button type="reset" class="btn btn-warning">重填</button>
			   		</div>
			   		<input type=hidden name="func" value="确认更新">
			   	</form>
				
			</div>
	
	</body>
</html>