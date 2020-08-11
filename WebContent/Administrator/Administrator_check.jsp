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
		   	overflow:auto;
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
				 		<input class='inp' name='message'>
				 		<input type=submit class='button' name='func' value='查询选择'><br>
				 		<input type="radio" name="inqueryType" value="colno">学院号
						<input type="radio" name="inqueryType" value="stuno">学号
						<input type="radio" name="inqueryType" value="teano">教师号
						<input type=hidden class="cano"  value="${cadmini.CAno}">
			 		</form>
			 		
				 	<table align="center" border="1" style="text-align: center; width: 100%;">
						<thead>
							<tr>
								<th width="10%">序号</th>
								<th width="10%">学院号</th>
								<th width="10%">学生号</th>
								<th width="10%">教师号</th>
								<th width="10%">双选状态</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
					        <c:forEach var="c" items="${chooseList}" varStatus="status">
					        
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.cno}</td>
					             <td>${c.sno}</td>
					             <td>${c.tno}</td>
					             <td>${c.status}</td>
					             <td>
					                <a href='../Administrator.action?func=确定选择&sno=${c.sno}&tno=${c.tno}'>确认</a> 
					                <a href='../Administrator.action?func=删除选择&sno=${c.sno}&tno=${c.tno}'>删除</a> 
					             </td>
					           </tr>
					       
					        </c:forEach>
				        </tbody>
					</table>
					
			 </div>
			 
			 
		   </div>
	     </div>
	     
	</body>
</html>