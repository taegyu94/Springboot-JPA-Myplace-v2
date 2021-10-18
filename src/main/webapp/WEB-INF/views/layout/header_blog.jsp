<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myblog</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</head>
<body>
	<div class="container-fluid text-center">
		<c:choose>
			<c:when test="${empty principal }">
				<h1>
					<a class="nav-link" href="/loginForm">누구의블로그?</a>
				</h1>
			</c:when>
			<c:otherwise>
				<h1>
					<a class="nav-link" href="/home/${user.blogname}">${user.blogname}의 블로그</a>
				</h1>
			</c:otherwise>
		</c:choose>

	</div>
	<br />

	<div class="offcanvas offcanvas-start" id="menubar">
		<div class="offcanvas-header">
			<h1 class="offcanvas-title">${user.blogname}의블로그</h1>		<!-- 세션에 저장되어있는 username  >>  로그인한 사람의 id -->
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"></button>
		</div>
		<div class="offcanvas-body">
			<p>Some text lorem ipsum.</p>
			<p>Some text lorem ipsum.</p>
			<p>Some text lorem ipsum.</p>
			<button class="btn btn-secondary" type="button">A Button</button>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-6">
			<div class="container-fluid mt-3">
				<button class="btn btn-primary " type="button" data-bs-toggle="offcanvas" data-bs-target="#menubar">MENU</button>
			</div>
		</div>


		<div class="col-sm-6">
			<ul class="nav justify-content-end">
				<c:if test="${user.id==principal.user.id}">
					<li class="nav-item"><a class="nav-link" href="/board/${user.blogname }/saveForm">글쓰기</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
			</ul>
		</div>


	</div>
	<hr />