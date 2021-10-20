<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header_blog.jsp"%>

<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id==principal.user.id}">
		<a href="/board/${board.user.blogname }/${board.id}/updateForm" class="btn btn-warning">수정</a>
		<button onclick="index.deleteById(${board.id},'${board.user.blogname }')"  class="btn btn-danger">삭제</button>
	</c:if>
	
	<br /><br />
	<div>
		글 번호 : <span id="id"><i>${board.id}</i></span> 
		작성자 : <span><i>${board.user.username}</i></span>
		카테고리 : <span><i>${board.category.subject}</i></span>
	</div>
	<br />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr />
	
	<div class="card">
		<form>
			<input type="hidden" id="userId" value="${principal.user.id }" />
			<input type="hidden" id="boardId" value="${board.id }" />
			<input type="hidden" id="blogname" value="${board.user.blogname }" />
			<c:choose>
				<c:when test="${empty principal }">
					<div class="card-body">
						<textarea id="reply-content" class="form-control" rows="1"  placeholder="로그인 후 이용가능합니다!"></textarea>
					</div>
					<div class="card-footer">
						<button id="btn-reply-save" type="button" class="btn btn-primary disabled">등록</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="card-body">
						<textarea id="reply-content" class="form-control" rows="1"  placeholder="댓글을 입력하세요!"></textarea>
					</div>
					<div class="card-footer">
						<button id="btn-reply-save" type="button" class="btn btn-primary">등록</button>
					</div>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
	<br/>
	
	<div class="card">
		<div class="card-header">댓글리스트</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys }">
			  	<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
  					<div>${reply.content}</div>
  					<div class="d-flex">
  						<div class="font-italic">작성자 : ${reply.user.username} &nbsp;</div>
  						<c:if test="${reply.user.id == principal.user.id or board.user.id == principal.user.id}">
  							<button onclick="index.replyDelete(${board.id}, ${reply.id}, '${board.user.blogname }')" class="badge">삭제</button>
  						</c:if>
  						
  					</div>
  				</li>
			</c:forEach>
		</ul>
	</div>
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer_blog.jsp"%>