<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员事务中心</title>
		<link rel="stylesheet" href="../bs\css\bootstrap.css">
		<script src="../bs/js/jquery-3.5.1.min.js"></script>
		<script src="../bs/js/bootstrap.js"></script>
		<script src="../bs/js/holder.js"></script>
		<%@ include file="MCSS.jsp" %>
		<script type='text/javascript'>
		    function search(){
		    	var func = document.getElementById("func");
		    	func.value = "获取学生";
		        
		    }
		    function modify(){
		    	var func = document.getElementById("func");
		    	func.value = "修改学生";
		    }
		</script>			
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="MNAV.jsp" %>
				
				<!--新增信息的模态框-->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addStu">新增学生</button>
				<div class="modal fade" id="addStu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">新增学生</h4>
					      </div>
				    	  <div class="modal-body">
					        <form name="stufrm" action="../Manager.action">
						 		<div class="form-group">
						   			<div class="input-group">
								      <div class="input-group-addon">学号</div>
								      <input type="text" class="form-control" name="sno">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon"> 姓名 </div>
								      <input type="text" class="form-control" name="sname">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">性别</div>
								      <input type="text" class="form-control" name="sex">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">成绩</div>
								      <input type="text" class="form-control" name="grade">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">本科院校</div>
								      <input type="text" class="form-control" name="school">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">密码</div>
								      <input type="text" class="form-control" name="pwd" value="123456">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">专业</div>
								      <input type="text" class="form-control" name="dis">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">邮箱</div>
								      <input type="text" class="form-control" name="email">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">电话</div>
								      <input type="text" class="form-control" name="phone">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">学院号</div>
								      <input type="text" class="form-control" name="cno">
								    </div>
						   		</div>
						 		<button type="submit" class="btn btn-primary">新增学生</button>
						 		<button class="btn btn-warning" type="reset">重填</button>
						 		<input type="hidden" name="func" value="新增学生" >
						 	</form>
					      </div>
				    </div>
				  </div>
				</div>		
				
				<!--修改信息的模态框-->
				<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modifyStu">修改学生</button><hr>
				<div class="modal fade" id="modifyStu" tabindex="-1" role="dialog" aria-labelledby="modifyStu">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="modifyStu">修改学生</h4>
					      </div>
				    	  <div class="modal-body">
					        <form name="stufrm" action="../Manager.action">
						 		<div class="form-group">
						 			<div class="input-group">
								      <input type="text" class="form-control" name="sno" placeholder="输入您要搜索的学号">
								      <span class="input-group-btn">
								        <button class="btn btn-default" type="submit" onclick="search()"><span class="glyphicon glyphicon-search"></span></button>
								      </span>
								    </div><hr>
								    <c:forEach var="a" items="${stu}" varStatus="status">
								    	<div class="input-group">
									      <div class="input-group-addon">学号</div>
									      <input type="text" class="form-control" name="modifysno" value="${a.sno}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon"> 姓名 </div>
									      <input type="text" class="form-control" name="sname" value="${a.sname}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">性别</div>
									      <input type="text" class="form-control" name="sex" value="${a.sex}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">成绩</div>
									      <input type="text" class="form-control" name="grade" value="${a.grade}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">本科院校</div>
									      <input type="text" class="form-control" name="school" value="${a.school}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">密码</div>
									      <input type="text" class="form-control" name="pwd" value="${a.pwd}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">专业</div>
									      <input type="text" class="form-control" name="dis" value="${a.discipline}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">邮箱</div>
									      <input type="text" class="form-control" name="email" value="${a.email}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">电话</div>
									      <input type="text" class="form-control" name="phone" value="${a.phone}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">学院号</div>
									      <input type="text" class="form-control" name="cno" value="${a.cno}">
									    </div>
								    </c:forEach>
						   		</div>
						 		<button type="submit" class="btn btn-primary" onclick="modify()" >确认修改</button>
						 		<button class="btn btn-warning" type="reset">重填</button>
						 		<input type="hidden" name="func" id="func" value="">
						 		
						 		
						 	</form>
					      </div>
				    </div>
				  </div>
				</div>
				
				<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th >序号</th>
								<th >学号</th>
								<th >姓名</th>
								<th >性别</th>
								<th >专业</th>
								<th >成绩</th>
								<th >本科所在院校</th>
								<th >密码</th>
								<th >电话</th>
								<th >邮箱</th>
								<th >学院号</th>
								<th >操作</th>
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
					             <td>${c.pwd}</td>
					             <td>${c.phone}</td>
					             <td>${c.email}</td>
					             <td>${c.cno}</td>
					             <td>
					                <a href='../Manager.action?func=删除学生&sno=${c.sno}'><button class="btn btn-danger">删除</button></a>
					             </td>
					           </tr>
					        </c:forEach>
				        </tbody>
					</table>
			</div>

	</body>
</html>