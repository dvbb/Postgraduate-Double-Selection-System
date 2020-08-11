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
					<table align="center" border="1" style="text-align: center; width: 100%;">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="10%">学号</th>
								<th width="5%">姓名</th>
								<th width="10%">性别</th>
								<th width="10%">专业</th>
								<th width="10%">成绩</th>
								<th width="20%">本科所在院校</th>
								<th width="15%">选择状态</th>
								<th width="20%">操作</th>
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
											<c:if test="${a.sno==c.sno&&a.status==2}">
												已选
											</c:if>
					             	</c:forEach>
					             </td>
					             <td>
					                <a href='../Teacher.action?sno=${c.sno}&tno=${teacher.tno}&func=cancel_byCheckFrm'>取消选择</a>
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