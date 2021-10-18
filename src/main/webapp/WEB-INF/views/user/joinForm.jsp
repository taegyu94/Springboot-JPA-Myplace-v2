<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header_intro.jsp"%>



<br/>


<div class="container">
	<form>
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
		<br/>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<br/>
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" name="emai" class="form-control" placeholder="Enter email" id="email">
		</div>
		<br/>
		<div class="form-group">
			<label for="blogname">blogname</label> 
			<input type="text" name="blogname" class="form-control" placeholder="Enter blogname" id="blogname">
		</div>
		<br/>
		
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입하기~!</button>

</div>


<script src="/js/user.js"></script>	
<%@ include file="../layout/footer_intro.jsp"%>