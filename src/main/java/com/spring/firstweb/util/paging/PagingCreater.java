package com.spring.firstweb.util.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingCreater {
	
	private PagingVO paging;
	private int contentCnt; // 게시물 총 갯수
	private int endPage; // 페이지번호 끝
	private int startPage; // 페이번호 시작
	private int btnPcs; 
	private boolean backBtn; // 이전btn
	private boolean nextBtn; // 다음 btn
	
	//setter 메서드 수정해서 contentCnt를 셋팅하면 자동으로 paging 알고리즘 실행 될 수 있도록 setter 커스텀
	public PagingCreater(int contentCnt,PagingVO paging) {
		this.paging = paging;
		this.contentCnt = contentCnt;
		this.btnPcs = 10; // 버튼 갯수는 픽스
		pagingalgorithm();
	}
	
	//페이징 알고리즘
	private void pagingalgorithm() {

		//17/10 => 1.7 => 2 * 10 => 20???
		endPage = (int)Math.ceil((double)paging.getSelPageNum()/btnPcs)*btnPcs;//28 -> 30
										//(전체 게시물 수 370 / 페이지 표시 수30) = 12.3333 => 13으로 올림  * 390
		//(끝 페이지 번호 * 게시물 갯수)  <= 	((선택한 페이지17 / 페이지 버튼 수10)[올림] /페이지 버튼 수)  ? 이전버튼 비활성화   => 12 / 10 = 1.2 => 2 * 10 => 20 
		startPage = (endPage - btnPcs) +1 ;
		
		backBtn = startPage == 1 ? false : true;
		
		nextBtn = contentCnt <= (endPage*paging.getContentPcs())? false : true;
		
		if(!nextBtn) {
			endPage = (int)Math.ceil((double)contentCnt / paging.getContentPcs());
		}
		
		
		/*						선택한 페이지 번호 / 버튼 갯수 * 버튼 갯수
		endPage = (int) (Math.ceil(paging.getPageNum() / (double) buttonNum) * buttonNum);
		
		beginPage = (endPage - buttonNum) + 1;
		
		prev = (beginPage == 1) ? false : true;
		
		next = articleTotalCount <= (endPage * paging.getCpp()) ? false : true;
		
		if(!next) {  endPage보정
			endPage = (int) Math.ceil(articleTotalCount / (double) paging.getCpp()); 
		}
		
	}
		*/
	}
	
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page",page)
																.queryParam("contentPcs", paging.getContentPcs())
																.queryParam("keyword", paging.getKeyword())
																.queryParam("condition", paging.getCondition())
																.build();
		System.out.println(ucp.toString());
		return ucp.toUriString();
	}
	
	
}
