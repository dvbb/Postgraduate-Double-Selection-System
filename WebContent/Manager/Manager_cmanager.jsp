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
		    	func.value = "获取院管理员";
		        
		    }
		    function modify(){
		    	var func = document.getElementById("func");
		    	func.value = "修改院管理员";
		    }
		</script>			
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="MNAV.jsp" %>
				
				<!--新增信息的模态框-->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addTea">新增院管理员</button>
				<div class="modal fade" id="addTea" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">新增院管理员</h4>
					      </div>
				    	  <div class="modal-body">
					        <form  action="../Manager.action">
						 		<div class="form-group">
						   			<div class="input-group">
								      <div class="input-group-addon">院管理员号</div>
								      <input type="text" class="form-control" name="cmno">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">密码</div>
								      <input type="text" class="form-control" name="pwd" value="123456">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">姓名</div>
								      <input type="text" class="form-control" name="cmname">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">学院号</div>
								      <input type="text" class="form-control" name="cno">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">电话</div>
								      <input type="text" class="form-control" name="phone">
								    </div>
						   		</div>
						 		<button type="submit" class="btn btn-primary">新增院管理员</button>
						 		<button class="btn btn-warning" type="reset">重填</button>
						 		<input type="hidden" name="func" value="新增院管理员" >
						 	</form>
					      </div>
				    </div>
				  </div>
				</div>		
				
				<!--修改信息的模态框-->
				<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modifyCmanager">修改院管理员</button><hr>
				<div class="modal fade" id="modifyCmanager" tabindex="-1" role="dialog" aria-labelledby="modifyCmanager">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="modifyCmanager">修改院管理员</h4>
					      </div>
				    	  <div class="modal-body">
					        <form action="../Manager.action">
						 		<div class="form-group">
						 			<div class="input-group">
								      <input type="text" class="form-control" name="searchCmno" placeholder="输入您要搜索的院管理员号">
								      <span class="input-group-btn">
								        <button class="btn btn-default" type="submit" onclick="search()"><span class="glyphicon glyphicon-search"></span></button>
								      </span>
								    </div><hr>
								    <c:forEach var="a" items="${cmanager}" varStatus="status">
								    	<div class="input-group">
									      <div class="input-group-addon">院管理员号</div>
									      <input type="text" class="form-control" name="cmno" value="${a.cmno}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">密码</div>
									      <input type="text" class="form-control" name="pwd" value="${a.pwd}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">姓名</div>
									      <input type="text" class="form-control" name="cmname" value="${a.cmname}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">学院号</div>
									      <input type="text" class="form-control" name="cno" value="${a.cno}">
									    </div>
									    <div class="input-group">
									      <div class="input-group-addon">电话</div>
									      <input type="text" class="form-control" name="phone" value="${a.phone}">
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
								<th >院管理员号</th>
								<th >密码</th>
								<th >姓名</th>
								<th >学院号</th>
								<th >电话</th>
								<th >操作</th>
							</tr>	
						</thead>
						<tbody>
					        <c:forEach var="c" items="${cmanagerList}" varStatus="status">
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.cmno}</td>
	             	             <td>${c.pwd}</td>					             
					             <td>${c.cmname }</td>
					             <td>${c.cno}</td>
								 <td>${c.phone}</td>
					             <td>
					                <a href='../Manager.action?func=删除院管理员&cmno=${c.cmno}'><button class="btn btn-danger">删除</button></a>
					             </td>
					           </tr>
					        </c:forEach>
				        </tbody>
					</table>
			</div>

	</body>
</html>