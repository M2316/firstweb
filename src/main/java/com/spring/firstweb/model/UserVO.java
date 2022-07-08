package com.spring.firstweb.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	/*
	CREATE TABLE users(
    user_id VARCHAR2(200) PRIMARY KEY,
    user_pw VARCHAR2(200) NOT NULL,
    user_name VARCHAR2(50) NOT NULL,
    phone1 NUMBER,
    phone2 NUMBER,
    email1 VARCHAR(200),
    email2 VARCHAR(200),
    address1 VARCHAR(200),
    address2 VARCHAR(200),
    address_zip VARCHAR(200),
    join_date DATE DEFAULT sysdate
    );
	*/
	private String userId;
	private String userPw;
	private String userName;
	private int phone1;
	private int phone2;
	private String email1;
	private String email2;
	private String address1;
	private String address2;
	private String addressZip;
	private Timestamp joinDate;
}
