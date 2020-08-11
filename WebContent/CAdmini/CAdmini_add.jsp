<%@ page language="java"  import="java.util.*,dao.CadminiDao,entity.Cadmini,java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>管理员</title>
		<%
			Cadmini cadmini=(Cadmini)session.getAttribute("cadmini");
			if(cadmini==null){
				out.print("<script>alert('您还没有登录，请登录...');  </script>");
				response.sendRedirect("../Login.html");
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
		   #button{
		   	width: 100px;
		   	height: 35px;
		   	margin: 10px 10px 0 10px;
		   }
		</style>
		
		<script type='text/javascript'>
			    function add_student(){
			    	alert("you click stu");
			    	document.stufrm.func.value="add_student";
			    }
			    function add_teacher(){
			    	alert("you click tea");
			    	document.teacherfrm.func.value="add_teacher";
			    }
		</script>
		
	</head>
	
	<body>
		
		 <div id="container">
		   <div id="header">
		   		<font class="title"  size="15">研究生双选系统</font><br>
		   		<font class="welcome"  size="5" >欢迎您，学院管理员${cadmini.caname}</font>
		   		
		   </div>
		   		
		   <div id="wrapper">
		   	
			 <div id="leftbar">
			 	<form action="../CAdmini.action" method="get">
				 	<input class="leftbutton" type="submit" name="func" value="主页"/>
				 	<input class="leftbutton" type="submit" name="func" value="新增人员"/>
				 	<input class="leftbutton" type="submit" name="func" value="查看双选"/>
				 	<input class="leftbutton" type="submit" name="func" value="维护学生信息"/>
				 	<input class="leftbutton" type="submit" name="func" value="维护教师信息"/>
				 	<input class="leftbutton" type="submit" name="func" value="更改密码"/>
				 	<input class="leftbutton" type="submit" name="func" value="安全退出"/>
				 	<input type=hidden name="cano"  value="${cadmini.CAno}">
				 	<input type=hidden name="cno"  value="${cadmini.cno}">
			 	</form>
			 </div>
			 
			 <div id="main">
			 		<font   size="6">新增学生：</font><br>
				 	<form name="stufrm" action="../CAdmini.action">
				 		<table align="center" border="1" style="text-align: center; width: 100%;">
							<thead>
								<tr>
									<th width="5%">学号</th>
									<th width="10%">姓名</th>
									<th width="5%">性别</th>
									<th width="10%">成绩</th>
									<th width="10%">本科院校</th>
									<th width="10%">专业</th>
									<th width="10%">学院号</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input  id="sno" name="sno" style="width:98%;height:20px"></td>
									<td><input  id="sname" name="sname" style="width:98%;height:20px"></td>
									<td>
										<select id="ssex" name="ssex" style="width:98%;height:20px">
											<option value="男">男</option>
											<option value="女">女</option>
										</select>
									</td>
									<td><input  id="grade" name="grade" style="width:98%;height:20px"></td>
									<td><input  id="school" name="school" style="width:98%;height:20px"></td>
									<td><input  id="sdiscipline" name="sdiscipline" style="width:98%;height:20px"></td>
									<td><input  id="scno" name="scno" style="width:98%;height:20px"></td>
								</tr>
							</tbody>
				 		</table>
				 		<input id="button" type=submit onclick="add_student()" value="确定新增">
						<input id="button" type=reset value="重填">
						<input name="func" value="">
				 	</form><br><br>
					
					
					
					
					
					
		
					
					
					
					
				 	<font   size="6">新增教师：</font><br>
				 	<form name="teacherfrm" action="../CAdmini.action">
				 		<table align="center" border="1" style="text-align: center; width: 100%;">
							<thead>
								<tr>
									<th width="10%">教师号</th>
									<th width="10%">姓名</th>
									<th width="10%">性别</th>
									<th width="10%">职称</th>
									<th width="10%">可带学生数</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input  id="tno" name="tno" style="width:98%;height:20px"></td>
									<td><input  id="tname" name="tname" style="width:98%;height:20px"></td>
									<td>
										<select name="tsex" style="width:98%;height:20px;">
											<option value="男">男</option>
											<option value="女">女</option>
										</select>
									</td>
									<td><input  id="title" name="title" style="width:98%;height:20px"></td>
									<td><input  id="leadnum" name="leadnum" style="width:98%;height:20px"></td>
								</tr>
							</tbody>
							<thead>
								<tr>
									
									<th colspan=2 width="10%">简介</th>
									<th width="10%">邮箱</th>
									<th width="10%">专业</th>
									<th width="10%">学院号</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									
									<td colspan=2><input  id="intro" name="intro" style="width:98%;height:20px"></td>
									<td><input  id="email" name="email" style="width:98%;height:20px"></td>
									<td><input  id="tdiscipline" name="tdiscipline" style="width:98%;height:20px"></td>
									<td><input  id="cno" name="cno" style="width:98%;height:20px"></td>
								</tr>
							</tbody>
				 		</table>
				 		<input id="button" type=submit onclick="add_teacher()" value="确定新增">
						<input id="button" type=reset  value="重填">
						<input name="func" value="">
				 	</form>
				 	
				 	
				 	
					
			 </div>
			 
		   </div>
	     </div>
	     
	</body>
</html>