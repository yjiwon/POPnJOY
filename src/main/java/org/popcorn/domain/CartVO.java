package org.popcorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class CartVO {

	private int cartNum;
	// private String userId; //회원
	private int gdsId; //상품

	private int CartStock;

	private Date cart_cklimit; //쿠키제한시간(삭제용)
	private String cart_ckid; //쿠키value값



}
