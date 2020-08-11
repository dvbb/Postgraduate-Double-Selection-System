<%@ page language="java"  import="java.util.*,dao.TeacherDao,entity.Teacher,java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>教师</title>
		<%
			Teacher teacher=(Teacher)session.getAttribute("teacher");
			if(teacher==null){
				out.print("<script>alert('您还没有登录，请登录...');  </script>");
				response.sendRedirect("Login.html");
			}
				
		%>
		
		<style type="text/css">
			*{		
			margin: 0;
			padding: 0;
			}
			#container{
				height: 720px;
				width:  100;	
				background-image: url(../img/background3.jpg);			
				background-position: center center;
				background-repeat: no-repeat;
				background-size: 100% 100%;
				positon:relative
			}
		   #header{
		   	height: 100px;
		    width: 80;
		    margin: 0 100px 20px 100px;
		   	background-image: url(../img/head.jpg);	
		   }
		   #header .title{
			margin: 0 0 0 20px;
		   }
		   #header .welcome{
			margin: 0 0 0 80px;
		   }
		   #wrapper{
		   	height: 600px;
		   	width: 100;
		   }
		   #leftbar{
		   	float:left;
		   	width:15%;
		   	height: 500px;
		   
		   	margin: 0 0 0 100px;
		   }
		    #main{
		   	float:right;
		   	width:70%;
		   	height:500px;
		   	margin: 0 100px 0 10px;
		   	border-style: solid;
		   }
		   #leftbar .leftbutton{
		   	align-items: center;
		   	width: 80%;
		   	height: 50px;
		   	margin: 10px 10% 0 10%;
		   }
		   
		</style>
		
		<script type='text/javascript'>
			    function verification(){
			         var old=document.getElementById("oldpwd").value;
			         var new1=document.getElementById("newpwd").value;
			         var new2=document.getElementById("newpwd2").value;
			         if(old==""||new1==""){
							alert("密码不能为空!"); 
							return false;
					}
			        if(new1!=new2){
			        	alert("两次输入的密码必须一致"); 
						return false;
			        }
			    }
		</script>
		
	</head>
	
	<body>
		
		 <div id="container">
		 
		   <div id="header">
		   		<font class="title"  size="15">研究生双选系统</font><br>
		   		<font class="welcome"  size="5" >欢迎您，${teacher.tname}老师</font>
		   		
		   </div>
		   		
		   <div id="wrapper">
		   	
			 <div id="leftbar">
			 	<form action="../Teacher.action" method="get">
				 	<input class="leftbutton" type="submit" name="func" value="主页"/>
				 	<input class="leftbutton" type="submit" name="func" value="选择学生"/>
				 	<input class="leftbutton" type="submit" name="func" value="查看选择"/>
				 	<input class="leftbutton" type="submit" name="func" value="更改密码"/>
				 	<input class="leftbutton" type="submit" name="func" value="安全退出"/>
				 	<input type=hidden name="tno" value="${teacher.tno}">
				 	
			 	</form>
			 </div>
			 
			 
			 
			 <div id="main">
					<font   size="6">个人信息：</font><br>
					<table align="center" border="1" style="text-align: center; width: 100%;">
						<thead>
							<tr>
								
								<th width="10%">教师名</th>
								<th width="5%">性别</th>
								<th width="10%">职称</th>
								<th width="10%">专业</th>
								<th width="10%">邮箱</th>
								<th width="20%">简介</th>
							</tr>
						</thead>
						<tbody>
					           <tr>
			     					
						             <td>${teacher.tname}</td>
						             <td>${teacher.sex}</td>
						             <td>${teacher.title}</td>
						             <td>${teacher.discipline}</td>
						             <td>${teacher.email}</td>
						             <td>${teacher.intro}</td>
			
					           </tr>
				        </tbody>
					</table><br>	
					
					
					
					
					
								
					
					
					
					
					
					<font   size="6">密码更新：</font><br>
					<form action="../Teacher.action" method="get">
						<table align="center" border="1" style="text-align: center; width: 50%;height:160px">
							<tbody>
						           <tr>
				     					<td>原密码：</td>
						            	<td><input type=password id="oldpwd" name="oldpwd" style="width:98%;height:100%"></td>
						           </tr>
						           <tr>
				     					<td>新密码：</td>
						            	<td><input type=password id="newpwd" name="newpwd" style="width:98%;height:100%"></td>
						           </tr>
						           <tr>
				     					<td>再次确认新密码：</td>
						            	<td><input type=password id="newpwd2" style="width:98%;height:100%"></td>
						           </tr>
						            <tr >
						            	<td colspan="2">
						            		<input type=submit style="width:20%;" onclick="verification()" value="确定">
						            		<input type=reset style="width:20%;">
						            	</td>
						           </tr>
					        </tbody>
						</table>
						<input type=hidden name="tno" value="${teacher.tno}">
						<input type=hidden name="func" value="pwdUpdate">
					</form>
					
			 </div>
			 
		   </div>
	     </div>
	     
	</body>
</html>