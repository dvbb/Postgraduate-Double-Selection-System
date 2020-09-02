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
		<%@ include file="CMCSS.jsp" %>			
	</head>
	
	<body>
			<div id="header">
			</div> 
			<div class="container">
				<%@ include file="CMNAV.jsp" %>
				
				<!--新增信息的模态框-->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addTea">新增双选关系</button>
				<div class="modal fade" id="addTea" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">新增双选关系</h4>
					      </div>
				    	  <div class="modal-body">
					        <form  action="../Manager.action">
						 		<div class="form-group">
						   			<div class="input-group">
								      <div class="input-group-addon">学号</div>
								      <input type="text" class="form-control" name="sno">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">教师号</div>
								      <input type="text" class="form-control" name="tno" >
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">学院号</div>
								      <input type="text" class="form-control" name="cno" value="${cno}" readonly="readonly">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">志愿</div>
								      <input type="text" class="form-control" name="wish">
								    </div>
								    <div class="input-group">
								      <div class="input-group-addon">双选状态</div>
								      <input type="text" class="form-control" name="status">
								    </div>
						   		</div>
						 		<button type="submit" class="btn btn-primary">新增双选关系</button>
						 		<button class="btn btn-warning" type="reset">重填</button>
						 		<input type="hidden" name="func" value="新增双选关系" >
						 	</form>
					      </div>
				    </div>
				  </div>
				</div>		
				
				<!--展示说明信息的模态框-->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myhelp">关于双选</button>
				<div class="modal fade" id="myhelp" tabindex="-1" role="dialog" >
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" >关于双选</h4>
					      </div>
				    	  <div class="modal-body">
				    	    <h4>1、关于志愿</h4>
					        	一位学生应该有三个志愿，且三个志愿<strong>唯一</strong>对应不同的教师。
					        <h4>2、关于选择状态</h4>
					        <h5>"0"代表学生选择了该导师</h5>
					        <h5>"1"代表导师选择了该学生，此时为互相选择关系</h5>
					        <h5>"2"代表在"1"的基础上，管理员最终确认并锁定了该双选关系</h5>
					      </div>
				    </div>
				  </div>
				</div>	
				
				<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th >序号</th>
								<th >学号</th>
								<th >教师号</th>
								<th >学院号</th>
								<th >志愿</th>
								<th >双选状态</th>
								<th >操作</th>
							</tr>	
						</thead>
						<tbody>
					        <c:forEach var="c" items="${chooseList}" varStatus="status">
					           <tr>
					             <td>${status.count}</td>
					             <td>${c.sno}</td>
	             	             <td>${c.tno}</td>					             
					             <td>${c.cno }</td>
					             <td>${c.wish}</td>
								 <td>${c.status}</td>
					             <td>
					            	<a href='../Manager.action?func=确认双选关系&sno=${c.sno}&wish=${c.wish}'><button class="btn btn-success">确认当前选择</button></a>
					                <a href='../Manager.action?func=删除双选关系&sno=${c.sno}&wish=${c.wish}'><button class="btn btn-danger">删除</button></a>
					             </td>
					           </tr>
					        </c:forEach>
				        </tbody>
					</table>
			</div>

	</body>
</html>