package com.Yoo.blogpractice.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Yoo.blogpractice.model.Board;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.BoardRepository;
import com.Yoo.blogpractice.service.BoardService;
import com.Yoo.blogpractice.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestRestController {

	private final UserService userService;
	private final BoardService boardService;

	@ModelAttribute("user")
	public User commonObject(@PathVariable String blogname, @PageableDefault(size = 5 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.글목록(pageable,blogname);
		List<Board> listBoard = pagingBoard.getContent();
		User user =  userService.블로그주인찾기(blogname);
		user.setBoard(listBoard);
		return user;
	}
	
	@GetMapping("/test/{blogname}")
	public void userHome(Model model,@PathVariable String blogname, @PageableDefault(size = 2 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.글목록(pageable,blogname);
//		List<Board> listBoard = pagingBoard.getContent();
//		User user =  userService.블로그주인찾기(blogname);
//		user.setBoard(listBoard);
//		model.addAttribute("user", user);
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
		//return user;
	}
	
//	@GetMapping("/test/{blogname}")
//	public Page<Board> userHome(Model model,@PathVariable String blogname, @PageableDefault(size = 3 , sort = "id" , direction = Sort.Direction.DESC) Pageable pageable) {
//		Page<Board> pagingBoard = boardService.글목록(pageable,blogname);
//		List<Board> listBoard = pagingBoard.getContent();
//		User user =  userService.블로그주인찾기(blogname);
//		user.setBoard(listBoard);
//		model.addAttribute("user", user);
//		return pagingBoard;
//	}
}
