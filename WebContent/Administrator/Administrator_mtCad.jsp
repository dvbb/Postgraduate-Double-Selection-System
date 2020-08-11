<%@ page language="java"  import="java.util.*,dao.AdministratorDao,entity.Administrator" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>管理员</title>
		<%
			Administrator admini=(Administrator)session.getAttribute("admini");
			if(admini==null){
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
		   		<font class="welcome"  size="5" >欢迎您，管理员</font>
		   		
		   </div>
		   		
		   <div id="wrapper">
		   	
			<div id="leftbar">
			 	<form action="../Administrator.action" method="get">
				 	<input class="leftbutton" type="submit" name="func" value="主页"/>
				 	<input class="leftbutton" type="submit" name="func" value="新增人员"/>
				 	<input class="leftbutton" type="submit" name="func" value="查看双选"/>
				 	<input class="leftbutton" type="submit" name="func" value="维护学生信息"/>
				 	<input class="leftbutton" type="submit" name="func" value="维护教师信息"/>
				 	<input class="leftbutton" type="submit" name="func" value="维护管理员信息"/>
				 	<input class="leftbutton" type="submit" name="func" value="更改密码"/>
				 	<input class="leftbutton" type="submit" name="func" value="安全退出"/>
			 	</form>
			 </div>
			 
			 <div id="main" style="text-align:center">
			 		
			 	<form action="../Administrator.action" method="get">
				 	<table align="center" border="1" style="text-align: center; width: 100%;">
						<thead>
							<tr>
								<th width="10%">管理员号</th>
								<th width="10%">姓名</th>
								<th width="10%">密码</th>
								<th width="10%">学院号</th>
								<th width="10%">操作</th>
							</tr>
						</thead>
						<tbody>
						 	<c:forEach var="c" items="${cadList}" varStatus="status">
					           <tr>
			     					<td>${c.CAno}</td>
			     					<td><input name="caname" style="width:98%;height:20px" value='${c.caname}'></td>
					            	<td><input name="pwd" style="width:98%;height:20px" value='${c.pwd}'></td>
					            	<td><input name="cno" style="width:98%;height:20px" value='${c.cno}'></td>
									<td>
										<input type=hidden name="cano"  value='${c.CAno}'>
					                	<input name="func" type=submit  value='更新管理员'>
					                	<input name="func" type=submit  value='删除管理员' >
					             	</td>
					           </tr>
					          </c:forEach>
				        </tbody>
					</table>
				</form>
			 		
			 		
					
			 </div>
			 
			 
		   </div>
	     </div>
	     
	</body>
</html>