package com.Yoo.blogpractice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Yoo.blogpractice.dto.ReplySaveRequestDto;
import com.Yoo.blogpractice.model.Board;
import com.Yoo.blogpractice.model.Category;
import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.BoardRepository;
import com.Yoo.blogpractice.repository.CategoryRepository;
import com.Yoo.blogpractice.repository.ReplyRepository;
import com.Yoo.blogpractice.repository.UserRepository;


@Service
public class BoardService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user, int categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()->{
					return new IllegalArgumentException("카테고리 찾기 실패 : 카테고리를 찾을 수 없습니다.");
				});
		board.setUser(user);
		board.setCount(0);
		board.setCategory(category);
		boardRepository.save(board);
	}
	
	@Transactional
	public Page<Board> 글목록(Pageable pageable, String blogname){
		User user = userRepository.findByBlogname(blogname)
				.orElseThrow(()->{
					return new IllegalArgumentException("블로그 찾기 실패 : 블로그를 찾을 수 없습니다.");
				});
		
		return boardRepository.findAllByUserId(pageable, user.getId());
	}
	
	@Transactional
	public Page<Board> 카테고리찾기(Pageable pageable, int categoryId){
		return boardRepository.findAllByCategoryId(pageable, categoryId);
	}
	
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
		});
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestboard) {
		Board board = boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
		});
		board.setTitle(requestboard.getTitle());
		board.setContent(requestboard.getContent());
		// 해당 함수 종료시 트랜잭션이 종료된다 이때 더티체킹이 일어나 자동업데이트된다.	
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}
	
	@Transactional
	public void 댓글삭제(int replyId) {
		replyRepository.deleteById(replyId);
	}
	
}
