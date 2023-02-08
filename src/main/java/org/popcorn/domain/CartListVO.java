package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CartListVO {

	private int cartNum;
	private int gdsId;
	private int CartStock;

	private Date cart_cklimit; //쿠키제한시간(삭제용)
	private String cart_ckid; //쿠키value값

	private int num;
	private String gdsName;
	private int gdsPrice;




}
