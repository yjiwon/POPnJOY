package org.popcorn.domain;

import lombok.Data;

@Data
public class MemberVO {
	
	private String userId;
	private String userPass;
	private String userName;
	private int verify;

}
