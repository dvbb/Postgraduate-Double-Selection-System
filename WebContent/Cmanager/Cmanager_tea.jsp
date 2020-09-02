<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>院管理员事务中心</title>
		<link rel="stylesheet" href="../bs\css\bootstrap.css">
		<script src="../bs/js/jquery-3.5.1.min.js"></script>
		<script src="../bs/js/bootstrap.js"></script>
		<script src="../bs/js/holder.js"></script>
		<%@ include file="CMCSS.jsp" %>
		<script type='text/javascript'>
		    function search(){
		    	var func = document.getElementById("func");
		    	func.value = "获取教师";
		        
		    }
		    function modify(){
		    	var func = document.getElementById("func");
		    	func.value = "修改教师";
		    }
		</script>			
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="CMNAV.jsp" %>
				
				<!--新增信息的模态框-->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addTea">新增教师</button>
				<div class="modal fade" id="addTea" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">新增教师</h4>
					      </div>
				    	  <div class="modal-body">
					        <form  action="../Manager.action">
						 		<div class="form-group">
						   			<div class="input-group">
								      <div class="input-group-addon">教师号</div>
								      <input type="text" class="form-control" name="tno">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon"> 姓名 </div>
								      <input type="text" class="form-control" name="tname">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">性别</div>
								      <input type="text" class="form-control" name="sex">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">职称</div>
								      <input type="text" class="form-control" name="title">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">可带学生数</div>
								      <input type="text" class="form-control" name="leadnum">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">简介</div>
								      <input type="text" class="form-control" name="intro" >
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">密码</div>
								      <input type="text" class="form-control" name="pwd" value="123456">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">邮箱</div>
								      <input type="text" class="form-control" name="email">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">专业</div>
								      <input type="text" class="form-control" name="dis">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">学院号</div>
								      <input type="text" class="form-control" name="cno" value="${cno}" readonly="readonly">
								    </div>
						   		</div>
						 		<button type="submit" class="btn btn-primary">新增教师</button>
						 		<button class="btn btn-warning" type="reset">重填</button>
						 		<input type="hidden" name="func" value="新增教师" >
						 	</form>
					      </div>
				    </div>
				  </div>
				</div>		
				
				<!--修改信息的模态框-->
				<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modifyTea">修改教师</button><hr>
				<div class="modal fade" id="modifyTea" tabindex="-1" role="dialog" aria-labelledby="modifyTea">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="modifyTea">修改教师</h4>
					      </div>
				    	  <div class="modal-body">
					        <form action="../Manager.action">
						 		<div class="form-group">
						 			<div class="input-group">
								      <input type="text" class="form-control" name="searchTno" placeholder="输入您要搜索的教师号">
								      <span class="input-group-btn">
								        <button class="btn btn-default" type="submit" onclick="search()"><span class="glyphicon glyphicon-search"></span></button>
								      </span>
								    </div><hr>
								    <c:forEach var="a" items="${teacher}" varStatus="status">
								    	<div class="input-group">
									      <div class="input-group-addon">教师号</div>
									      <input type="text" class="form-control" name="tno" value="${a.tno}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon"> 姓名 </div>
									      <input type="text" class="form-control" name="tname" value="${a.tname}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">性别</div>
									      <input type="text" class="form-control" name="sex" value="${a.sex}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">职称</div>
									      <input type="text" class="form-control" name="title" value="${a.title}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">可带学生数</div>
									      <input type="text" class="form-control" name="leadnum" value="${a.leadnum}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">简介</div>
									      <input type="text" class="form-control" name="intro" value="${a.intro}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">密码</div>
									      <input type="text" class="form-control" name="pwd" value="${a.pwd}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">邮箱</div>
									      <input type="text" class="form-control" name="email" value="${a.email}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">专业</div>
									      <input type="text" class="form-control" name="dis" value="${a.discipline}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">学院号</div>
									      <input type="text" class="form-control" name="cno" value="${a.cno}"  readonly="readonly">
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
								<th >教师号</th>
								<th >姓名</th>
								<th >性别</th>
								<th >职称</th>
								<th >可带学生数</th>
								<th >简介</th>
								<th >密码</th>
								<th >邮箱</th>
								<th >专业</th>
								<th >学院号</th>
								<th >操作</th>
							</tr>	
						</thead>
						<tbody>
					        <c:forEach var="c" items="${teacherList}" varStatus="status">
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.tno}</td>
					             <td>${c.tname }</td>
					             <td>${c.sex}</td>
					             <td>${c.title}</td>
					             <td>${c.leadnum}</td>
					             <td>${c.intro}</td>
					             <td>${c.pwd}</td>
					             <td>${c.email}</td>
					             <td>${c.discipline}</td>
					             <td>${c.cno}</td>
					             <td>
					                <a href='../Manager.action?func=删除教师&tno=${c.tno}'><button class="btn btn-danger">删除</button></a>
					             </td>
					           </tr>
					        </c:forEach>
				        </tbody>
					</table>
			</div>

	</body>
</html>