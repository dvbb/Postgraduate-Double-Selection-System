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
		    #main .inp{
		    align-items: center;
		    width: 60%;
		   	height: 30px;
		   	margin: 10px 0 10px 10%;
		   }
		    #main .button{
		    align-items: center;
		    width: 15%;
		   	height: 30px;
		   	margin: 10px 10% 10px 20px;
		   }
		   #main .radio{
		    align-items: center;
		   	vertical-align:middle;
		   }
		</style>
		
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
				 	<input type=hidden class="cano"  value="${cadmini.CAno}">
				 	<input type=hidden name="cno"  value="${cadmini.cno}">
			 	</form>
			 </div>
			 
			 <div id="main" style="text-align:center">
			 
			 		<form action="../CAdmini.action" method="get">
				 		<input class='inp' name='message'>
				 		<input type=submit class='button' name='func' value='查询教师'><br>
						<input type="radio" name="inqueryType" value="teano">教师号
						<input type="radio" name="inqueryType" value="teaname">教师名
						<input type=hidden class="cano"  value="${cadmini.CAno}">
						<input type=hidden name="cno"  value="${cadmini.cno}">
			 		</form>
			 		
			 		
			 		<form action="../CAdmini.action" method="get">
				 	<table align="center" border="1" style="text-align: center; width: 100%;">
				 	 <c:forEach var="c" items="${tealist}" varStatus="status">
						<thead>
							<tr>
								<th width="10%">教师号</th>
								<th width="10%">姓名</th>
								<th width="10%">性别</th>
								<th width="10%">职称</th>
								<th width="10%">带领学生数</th>
							</tr>
						</thead>
						<tbody>
					           <tr>
					             <td>${c.tno}</td>
					             <td><input name="tname" style="width:98%;height:20px" value='${c.tname}'></td>
					             <td><input name="sex" style="width:98%;height:20px" value='${c.sex}'></td>
					             <td><input name="title" style="width:98%;height:20px" value='${c.title}'></td>
					             <td><input name="leadnum" style="width:98%;height:20px" value='${c.leadnum}'></td>
					             
					           </tr>
				        </tbody>
				        <thead>
							<tr>
								<th width="10%">简介</th>
								<th width="10%">密码</th>
								<th width="10%">邮箱</th>
								<th width="10%">专业</th>
								<th width="10%">操作</th>
							</tr>
						</thead>
						<tbody>
					           <tr>
					             <td><input name="intro" style="width:98%;height:20px" value='${c.intro}'></td>
					             <td><input name="pwd" style="width:98%;height:20px" value='${c.pwd}'></td>
					             <td><input name="email" style="width:98%;height:20px" value='${c.email}'></td>
					             <td><input name="dis" style="width:98%;height:20px" value='${c.discipline}'></td>
					             <td>
					                <input type=hidden name="tno"  value='${c.tno}'>
				                	<input name="func" type=submit  value='更新教师信息'>
				                	<input name="func" type=submit  value='删除教师'>
					             </td>
					           </tr>
				        </tbody>
				        </c:forEach>
					</table>
					</form>
				 	
				 	
					
			 </div>
			 
		   </div>
	     </div>
	     
	</body>
</html>