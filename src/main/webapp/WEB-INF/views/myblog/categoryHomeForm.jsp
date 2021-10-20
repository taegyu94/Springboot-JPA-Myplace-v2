<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ include file="../layout/header_blog.jsp"%>

<div class="container">
	<h1 align="center">${catesubject}</h1>
	<br/>
	<c:forEach var="cateboard" items="${cateboards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${cateboard.title}</h4>
				<a href="/board/${cateboard.user.blogname }/${cateboard.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${cateboards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${cateboards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${cateboards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${cateboards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${cateboards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>	


</div>

<%@ include file="../layout/footer_blog.jsp"%>