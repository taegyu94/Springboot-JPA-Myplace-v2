package com.Yoo.blogpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.Yoo.blogpractice.model.Board;
import com.Yoo.blogpractice.model.Category;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.service.BoardService;
import com.Yoo.blogpractice.service.CategoryService;
import com.Yoo.blogpractice.service.UserService;


@Controller
public class BoardController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("user")
	public User commonObject(@PathVariable String blogname, @PageableDefault(size = 5 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.글목록(pageable,blogname);
		List<Board> listBoard = pagingBoard.getContent();
		User user =  userService.블로그주인찾기(blogname);
		List<Category> category = categoryService.카테고리찾기(user.getId());
		user.setBoard(listBoard);
		user.setCategory(category);
		return user;
	}
	
	 //model 은 request 정보라고 생각하자 Controller 에서 페이지를 응답해줄때, 이 model의 정보를 가지고 간다.
	 //@PageableDefault 특정 페이지를 호출
	@GetMapping("/home/{blogname}")
	public String userHome(Model model,@PathVariable String blogname, @PageableDefault(size = 5 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.글목록(pageable,blogname);
		boolean last = false;
		boolean first = false;
		int pageNumber = pagingBoard.getNumber();	//현재페이지
		if (pagingBoard.getTotalPages() - pageNumber -1 == 0) {
			last = true;
		}else if (pageNumber == 0) {
			first = true;
		}else {
			last = false;
			first = false;
		}
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("first", first);
		model.addAttribute("last", last);
		return "/myblog/myhome";
	}
	
	@GetMapping("/home/{blogname}/{subject}/{id}")
	public String userCategoryHome(Model model,@PathVariable String subject, @PathVariable int id, @PageableDefault(size = 5 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.카테고리찾기(pageable,id);
		model.addAttribute("cateboards",pagingBoard);
		model.addAttribute("catesubject",subject);
		return "/myblog/categoryHomeForm";
	}
	
	@GetMapping("/board/{blogname}/{id}")	// 글쓰기가 가능한 곳은 자신의 블로그.
	public String boardDetail(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "/board/detail";
	}
	
	@GetMapping("/board/{blogname}/{id}/updateForm")
	public String boardUpdate(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "/board/updateForm";
	}
	
	@GetMapping("/board/{blogname}/saveForm")
	public String boardSaveForm() {
		return "/board/saveForm";
	}
	
	@GetMapping("/board/category/{blogname}")
	public String categorySaveForm() {
		return "/board/CategorySaveForm";
	}
	
	
	
}
