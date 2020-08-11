<%@ page language="java"  import="java.util.*,dao.StudentDao,entity.Student,java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>学生</title>
		<%
			Student stu=(Student)session.getAttribute("stu");
			if(stu==null){
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
				background-image: url(img/background3.jpg);			
				background-position: center center;
				background-repeat: no-repeat;
				background-size: 100% 100%;
				positon:relative
			}
		   #header{
		   	height: 100px;
		    width: 80;
		    margin: 0 100px 20px 100px;
		   	background-image: url(img/head.jpg);	
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
		   		<font class="welcome"  size="5" >欢迎您，${stu.sname}同学</font>
		   		
		   </div>
		   		
		   <div id="wrapper">
		   	
			 <div id="leftbar">
			 	<form action="student.action?cno=${stu.cno}&discipline=${stu.discipline}" method="get">
				 	<input class="leftbutton" type="submit" name="func" value="主页"/>
				 	<input class="leftbutton" type="submit" name="func" value="选择导师"/>
				 	<input class="leftbutton" type="submit" name="func" value="查看选择"/>
				 	<input class="leftbutton" type="submit" name="func" value="更改密码"/>
				 	<input class="leftbutton" type="submit" name="func" value="安全退出"/>
				 	<input type=hidden name="sno" value="${stu.sno}">
				 	<input type=hidden name="discipline" value="${stu.discipline}">
		   			<input type=hidden name="cno" value="${stu.cno}">
			 	</form>
			 </div>
			 
			 <div id="main">
			 				 	
				 	<table align="center" border="1" style="text-align: center; width: 100%;">
						<thead>
							<tr>
								<th width="5%">序号</th>
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
					        
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.tname}</td>
					             <td>${c.sex}</td>
					             <td>${c.title}</td>
					             <td>${c.discipline}</td>
					             <td>${c.email}</td>
					             <td>${c.intro}</td>
					             <td>
					             	<c:forEach var="a" items="${chooselist}">		
											<c:if test="${a.tno==c.tno}">
												已选
											</c:if>
					             	</c:forEach>
					             </td>
					             <td>
					                <a href='student.action?sno=${stu.sno}&cno=${stu.cno}&tno=${c.tno}&func=choose'>选择</a>
					                <a href='student.action?sno=${stu.sno}&cno=${stu.cno}&tno=${c.tno}&func=cancel'>退选</a>
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