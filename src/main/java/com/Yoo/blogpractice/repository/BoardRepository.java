package com.Yoo.blogpractice.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Yoo.blogpractice.model.Board;


public interface BoardRepository extends JpaRepository<Board, Integer>{

	public Page<Board> findAllByUserId(Pageable pageable , int  userId);
}
