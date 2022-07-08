package com.spring.firstweb.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE board (
	bno NUMBER PRIMARY KEY,
	writer VARCHAR2(50) NOT NULL,
	title VARCHAR2(200) NOT NULL,
	content VARCHAR2(2000) NOT NULL,
	reg_date DATE DEFAULT sysdate,
    mod_date DATE null,
    view_point NUMBER	
	); 
CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
*/
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int bno;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate; // 작성 시간
	private Timestamp modDate; // 수정 시간
	private int viewPoint; // 조회 수
}
