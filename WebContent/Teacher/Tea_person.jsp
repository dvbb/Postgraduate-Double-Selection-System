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
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="TeaNAV.jsp" %>		
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>教师号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>职称</th>
							<th>带领学生数</th>
							<th>简介</th>
							<th>邮箱</th>
							<th>专业</th>
							<th>学院号</th>
						</tr>
					</thead>
					<tbody>
				           <tr>
		     					<td>${user.tno}</td>
				            	<td>${user.tname}</td>
				            	<td>${user.sex}</td>
				            	<td>${user.title}</td>
				            	<td>${user.leadnum}</td>
				            	<td>${user.intro}</td>
				            	<td>${user.email}</td>
				            	<td>${user.discipline}</td>
				            	<td>${user.cno}</td>
		
				           </tr>
			        </tbody>
				</table>
				
				<form action="../Teacher.action?func=确认更新" method="get">
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