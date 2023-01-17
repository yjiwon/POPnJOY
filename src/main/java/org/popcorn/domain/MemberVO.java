package org.popcorn.domain;

import lombok.Data;

@Data
public class MemberVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private int verify;

}
