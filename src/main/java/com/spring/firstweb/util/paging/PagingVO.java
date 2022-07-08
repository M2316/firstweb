package com.spring.firstweb.util.paging;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PagingVO {
	private String keyword;
	private String condition;
	
	private int selPageNum;
	private int contentPcs;
	
	public PagingVO() {
		this.selPageNum = 1; //초기 값은 1페이지 선택화면
		this.contentPcs = 10; // 초기 값은 30개씩 게시물 표시
	}

}
