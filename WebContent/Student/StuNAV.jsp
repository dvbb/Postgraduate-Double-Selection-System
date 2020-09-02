<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">学生事务中心</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="../student.action?func=主页">主页 <span class="sr-only">(current)</span></a></li>
        <li><a href="../student.action?func=选择导师">选择导师</a></li>
        <li><a href="../student.action?func=查看选择">查看选择</a></li>
        <li><a href="../student.action?func=更改密码">更改密码</a></li>
        <li><a href="../student.action?func=安全退出">安全退出</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <div class="form-group">
         	 <input type="text" class="form-control" placeholder="Search">
        </div>
        	<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
      </form>
    </div>
  </div>
</nav>