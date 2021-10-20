let index = {
	init: function() {
		$("#btn-save").on("click", ()=> {
			this.save();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});
		$("#btn-category-save").on("click", () => {
			this.categorySave();
		});
	},

	save: function() {
		let blogname = $("#blogname").val();
		let categoryId = $("#categoryId").val();
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};
		console.log(data);
		$.ajax({
			type: "POST",
			url: "/api/board/"+categoryId,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/home/"+blogname;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	update: function() {
		let id = $("#id").val();
		let blogname = $("#blogname").val();
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/update/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글수정가 완료되었습니다.");	
			location.href = "/home/"+blogname;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function(boardId,blogname) {

		$.ajax({
			type: "DELETE",
			url: `/api/board/delete/${boardId}` ,
			dataType: "json"
		}).done(function(resp) {
			alert("글삭제가 완료되었습니다.");
			location.href = `/home/${blogname}`;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replySave: function() {
		let blogname = $("#blogname").val();
		
		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		};

		$.ajax({
			type: "POST",
			url: `/api/board/reply/${data.boardId}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글작성이 완료되었습니다.");
			location.href = `/board/${blogname}/${data.boardId}`;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replyDelete : function(boardId, replyId, blogname) {

		$.ajax({
			type: "DELETE",
			url: `/api/board/${boardId}/replydelete/${replyId}`,
			dataType: "json"
		}).done(function(resp) {
			alert("댓글 삭제가 완료되었습니다.");
			location.href = `/board/${blogname}/${boardId}`;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	categorySave: function() {
		let blogname = $("#blogname").val();
		
		let data = {
			subject : $("#subject").val()
		};
		console.log(data);
		$.ajax({
			type: "POST",
			url: "/api/board/category",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("카테고리 저장이 완료되었습니다.");
			location.href = `/board/category/`+blogname;
			console.log(resp);
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	
}

index.init();