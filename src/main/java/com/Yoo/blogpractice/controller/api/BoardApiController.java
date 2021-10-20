package com.Yoo.blogpractice.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Yoo.blogpractice.config.auth.PrincipalDetails;
import com.Yoo.blogpractice.dto.ResponseDto;
import com.Yoo.blogpractice.model.Board;
import com.Yoo.blogpractice.model.Category;
import com.Yoo.blogpractice.service.BoardService;
import com.Yoo.blogpractice.service.CategoryService;


@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/api/board/{categoryId}")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal, @PathVariable int categoryId) {
		boardService.글쓰기(board, principal.getUser(),categoryId);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
	@PostMapping("/api/board/category")
	public ResponseDto<Integer> categorySave(@RequestBody Category category, @AuthenticationPrincipal PrincipalDetails principal){
		categoryService.카테저장(category, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
	@PutMapping("/api/board/update/{id}")
	public ResponseDto<Integer> update(@PathVariable int id ,@RequestBody Board board) {
		boardService.글수정하기(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
	@DeleteMapping("/api/board/delete/{id}")
	public ResponseDto<Integer> delete(@PathVariable int id) {
		boardService.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
	
	@DeleteMapping("/api/categorydelete/{categoryId}")
	public ResponseDto<Integer> cateDelete(@PathVariable int categoryId){
		categoryService.카테삭제(categoryId);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
}
