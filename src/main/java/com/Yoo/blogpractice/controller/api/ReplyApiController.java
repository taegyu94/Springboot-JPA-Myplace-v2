package com.Yoo.blogpractice.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Yoo.blogpractice.dto.ReplySaveRequestDto;
import com.Yoo.blogpractice.dto.ResponseDto;
import com.Yoo.blogpractice.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {
	
	private final BoardService boardService;

	@PostMapping("/api/board/reply/{boardId}")
	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaverequestDto){
		boardService.댓글쓰기(replySaverequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
		
	@DeleteMapping("/api/board/{boardId}/replydelete/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardService.댓글삭제(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
	}
}
