package com.spring.firstweb;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.firstweb.mapper.IBoardMapper;
import com.spring.firstweb.util.paging.PagingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PagingTest {
	@Autowired
	private IBoardMapper mapper;
	/*
	    *** 페이징 알고리즘 만들기 ***
	    
	    # 1. 총 게시물의 수를 조회해야 합니다.
	    - 총 게시물 수는 DB로부터 수를 조회하는 SQL문 작성.
	    
	    # 2. 사용자가 현재 위치한 페이지를 기준으로
	     끝 페이지 번호를 계산하는 로직 작성.
	    
	    - 만약 현재 사용자가 보고 있는 페이지가 3페이지고,
	     한 화면에 보여줄 페이지 버튼이 10개씩이면? -> 10페이지.
	     공식: Math.ceil(현재 위치한 페이지 번호 / 페이지 버튼 개수) * 페이지 버튼 개수
	     			└> 실수의 부분을 올림하여주는 함수이기 때문에 int로 계산하면 실수 부분이 0 이므로 
	     				(double)로 형변환 한다음 계산이 이루어져야 한다
	    
	    # 3. 시작페이지 번호 구하기
	    공식: (끝 페이지 번호 - 페이지 버튼 개수) + 1
	    
	    # 4. 이전 버튼 활성 여부
	    공식: 시작페이지가 1이면 비활성, 나머지는 모두 활성.
	    
	    # 5. 다음 버튼 활성 여부
	    공식: 보정 전 끝 페이지 번호 * 한 페이지에 들어갈 게시물의 수 >= 총 게시물 수
	        -> 비활성.
	        
	    # 6. 끝 페이지 값 보정
	    - 다음 버튼이 비활성화 되었을 때 사용. (필요없는 버튼을 제거하는 용도로)
	    - 공식: Math.ceil(총 게시물 수 / 한 페이지에 보여줄 게시물 수)
	    */
	/*
	@Test
	public void pagingTest() {
		int count = mapper.countContents(PagingVO);
		int pageContentCount = 20;
		
		int pageBtnConunt =10;
		int currentPageNum =23;
		
		
		int endPageBtn = (int)(Math.ceil((double)currentPageNum/pageBtnConunt)*pageBtnConunt);//끝 페이지 번호 계산
		int startPageBtn = (endPageBtn-pageBtnConunt)+1; 	// 시작 페이지 번호 계산
		
		boolean backBtn =true 
				,nextBtn = true;
		
		int endPageBtnNew = 0 ;
		
		
		if(startPageBtn == 1) {
			nextBtn = false;
		}else if (endPageBtn*pageContentCount >= count) {
			nextBtn = false;
		}
		
		if(!nextBtn) {
			endPageBtnNew = (int)Math.ceil((double)count/pageContentCount);
		}
		
		
		
		System.out.println(count);
		System.out.println((double)currentPageNum/pageBtnConunt);
		System.out.println(endPageBtn); 
		
		
		System.out.println(endPageBtnNew != 0 ?endPageBtnNew:"");
		System.out.println(backBtn ? "<이전>":"");
		System.out.println(nextBtn ? "<다음>":"");
		
	}
	*/
}
