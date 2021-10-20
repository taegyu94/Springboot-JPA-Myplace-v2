<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header_intro.jsp"%>

<br/>

<div class="container ">
	<h1 align="center">검색결과</h1>
	<br />
	<div class ="row justify-content-center">
		<div class="card  text-center m-5 col-sm-4 p-3" style="width: 400px">
			<div class="card-body " >
				<h4 class="card-title ">${searchblog.blogname}의 블로그</h4>
				<br/>
				<a href="/home/${searchblog.blogname}" class="btn btn-primary ">찾아가기</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="../layout/footer_intro.jsp"%>