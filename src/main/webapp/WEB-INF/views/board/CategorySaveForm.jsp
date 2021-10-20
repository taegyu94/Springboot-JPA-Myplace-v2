<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header_blog.jsp"%>


<div class="container-md">
	<h1>카테고리 추가 및 수정</h1>
	<br />
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<br/><br/>
	<div class="card">
		<div class="card-header">
			<h4>Category</h4>
		</div>
		<div class="card-body" id = "categorycard">
			<ul id="category-box" class="list-group">
				<c:forEach var="category" items="${user.category}">
					<li id="category-${category.id}" class="list-group-item d-flex justify-content-between">
						<div>${category.subject}</div>
						<div class="d-flex">
							<button onclick="index.cateDelete(${category.id},'${user.blogname}')" class="btn btn-danger btn-sm">삭제</button>						
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="card-footer">
			<div class = "row">
				<div class=col-sm-8>
					<input type="text" class="form-control" placeholder="Enter Category name" id="subject">
					<input type="hidden" id="blogname" value="${user.blogname }" />
				</div>
				<div class=col-sm-4> 
					<input id="btn-category-save" class ="btn btn-success btn-sm"  type='button' value='저장' />
				</div>
			</div>
		</div>
	</div>
</div>



<script src="/js/board.js"></script>
<%@ include file="../layout/footer_blog.jsp"%></html>