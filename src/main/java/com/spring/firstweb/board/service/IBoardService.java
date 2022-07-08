package com.spring.firstweb.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.firstweb.mapper.IBoardMapper;
import com.spring.firstweb.model.BoardVO;
import com.spring.firstweb.util.paging.PagingVO;


public interface IBoardService {
	
	//게시글 등록
	void insertContent(BoardVO vo);
	
	//게시글 전체 조회 기능(페이징 전)
	List<BoardVO> getContentAll(PagingVO paging);
	
	//게시글 상세 조회 기능
	BoardVO getContent(int bno);
	//게시글 수정
	void modContent(BoardVO content);
	//게시글 삭제 
	void delContent(int bno);
	//게시글 수 조회 기능
	int countContents(PagingVO paging);
}
