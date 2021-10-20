<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header_blog.jsp"%>

<div class="container">
	<h1>글쓰기</h1>
	<br />

	<form>
		<h3>category</h3>
		<select name="category" onchange="handleOnChange(this)">
			<option ></option>
			
			<c:forEach var="category" items="${user.category}">
				<option value="${category.id}">${category.subject}</option>
			</c:forEach>		
			
		</select>
		<input type="hidden" id="categoryId" value=" " />
		
		<a href = "/board/category/${user.blogname}" class = "btn btn-info btn-sm" >카테고리 수정 및 추가하기</a>
		
		<br/><br/>
		<h3>title</h3>
		<input type="hidden" id="blogname" value="${user.blogname }" />
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>

		<br />
		<h3>content</h3>
		<div class="form-group">
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>

	</form>
	<br />
	<button id="btn-save" class="btn btn-primary">글쓰기완료</button>
</div>

<script>
	// 메인화면 페이지 로드 함수
	$(document).ready(function() {
		$('.summernote').summernote({
			placeholder : '내용을 작성하세요',
			height : 400,
			maxHeight : 400
		});
	});
	
	function handleOnChange(e) {
		// 선택된 데이터 가져오기
		const value = e.value;
	  	var el = document.getElementById('categoryId');
	  	// 데이터 출력
	  	//document.getElementById('result').innerText = value;
	  	//${'#result'}.attr('value',value);
	  	// 'id = result' 인 태그에 'value' 속성에 value값을 추가
	  	// 변수 value 는 선택된 데이터
	  	el.setAttribute('value',value);
	}
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer_blog.jsp"%></html>