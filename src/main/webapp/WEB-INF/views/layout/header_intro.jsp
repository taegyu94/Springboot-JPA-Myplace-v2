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
<title>MySpace</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">MySpace</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav me-auto">
					<c:choose>
						<c:when test="${empty principal }">
							<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/joinForm">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/home/${principal.user.blogname }">내블로그로</a></li>
							<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
					<!-- <li class="nav-item"><a class="nav-link" href="javascript:void(0)">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="javascript:void(0)">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="javascript:void(0)">Link</a></li> -->
				</ul>
				<form class="d-flex">
					<input class="form-control me-4" type="text" placeholder="블로그 이름을 입력하세요" id = "searchBlogname">
				</form>
					<button id="btn-search" class="btn btn-primary" type="button">Search</button>
			</div>
		</div>
	</nav>