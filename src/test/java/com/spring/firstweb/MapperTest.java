package com.spring.firstweb;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.firstweb.mapper.IBoardMapper;
import com.spring.firstweb.model.BoardVO;
import com.spring.firstweb.util.paging.PagingCreater;
import com.spring.firstweb.util.paging.PagingVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {

	@Autowired
	private IBoardMapper mapper;

	@Test
	public void insertTest() {
		
		BoardVO vo = new BoardVO();
		for (int i = 0 ; i< 500; i++) {
			vo.setTitle("test 제목입니다."+i);
			vo.setContent("test 내용입니다."+i);
			vo.setWriter("Tester");
			vo.setViewPoint(0);
			
			
			mapper.insertContent(vo);
			
		}
		
		
		
	}
// paging TEST
	@Test
	public void getContentAllTest() {
		PagingVO paging = new PagingVO();
		
		paging.setSelPageNum(3);
		paging.setContentPcs(30);
		
/*
		PagingCreater pc = new PagingCreater(mapper.countContents(),paging);
		
		System.out.println("게시물수 " + pc.getPaging().getContentPcs());
		System.out.println("선택한 페이지 " + pc.getPaging().getSelPageNum());
		System.out.println("시작페이지 " + pc.getStartPage());
		System.out.println("끝 페이지 " + pc.getEndPage());
		System.out.println("이전 버튼 " + pc.isBackBtn());
		System.out.println("다음 버튼 " + pc.isNextBtn());
		
		
		List<BoardVO> vo = mapper.getContentAll(paging);
		
		for(BoardVO content : vo) {
			System.out.println(content);
		}
		
		
		*/
	}
}
