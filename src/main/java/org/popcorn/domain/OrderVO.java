package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVO {

	private String orderId; // 주문 고유번호
	private String orderPhone; //주문자 폰 번호
	private int amount; //총 가격
	private Date orderDate; //주문한 시간

}
