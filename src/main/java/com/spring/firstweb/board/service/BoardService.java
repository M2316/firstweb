package com.spring.firstweb.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.firstweb.mapper.IBoardMapper;
import com.spring.firstweb.model.BoardVO;
import com.spring.firstweb.util.paging.PagingVO;


@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insertContent(BoardVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> getContentAll(PagingVO paging) {
		return mapper.getContentAll(paging);
	}

	@Override
	public BoardVO getContent(int bno) {
		
		return mapper.getContent(bno);
	}

	@Override
	public void modContent(BoardVO content) {
		mapper.modContent(content);

	}

	@Override
	public void delContent(int bno) {
		mapper.delContent(bno);

	}

	@Override
	public int countContents(PagingVO paging) {
		return mapper.countContents(paging);
	}

}
