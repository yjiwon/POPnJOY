package org.popcon.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private int verify;

}
