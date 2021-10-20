<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ include file="layout/header_intro.jsp"%>
<!-- Carousel -->
<div class="container-fluid mt-3">
	<br />
	<h1 align="center">어떤 블로그로??</h1>

	<div class="row justify-content-center">
		<c:forEach var="user" items="${users.content}">
			<div class="card m-5 col-sm-4 p-3" style="width: 400px">
				<div class="card-body ">
					<h4 class="card-title">${user.blogname}의블로그</h4>
					<a href="/home/${user.blogname}" class="btn btn-primary">들어가기</a>
				</div>
			</div>
		</c:forEach>
	</div>


	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${users.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${users.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<br />
<div id="demo" class="carousel slide" data-bs-ride="carousel">

	<!-- Indicators/dots -->
	<div class="carousel-indicators">
		<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
		<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
		<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
	</div>

	<!-- The slideshow/carousel -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="/image/Newyork.jpg" alt="Newyork" class="d-block w-100">
		</div>
		<div class="carousel-item">
			<img src="/image/Seoul.jpg" alt="Seoul" class="d-block w-100">
		</div>
		<div class="carousel-item">
			<img src="/image/London.jpg" alt="London" class="d-block w-100">
		</div>
	</div>

	<!-- Left and right controls/icons -->
	<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
		<span class="carousel-control-prev-icon"></span>
	</button>
	<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
		<span class="carousel-control-next-icon"></span>
	</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="layout/footer_intro.jsp"%>