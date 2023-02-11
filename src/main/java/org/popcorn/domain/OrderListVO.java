package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderListVO {

	private String orderId;
	private String cart_ckid;
	private String orderRec;
	private String orderPhone;
	private int amount;
	private Date orderDate;
	private String delivery;

	private int orderDetailsNum;
	private int gdsId;
	private int cartStock;

	private String gdsName;
	private int gdsPrice;

}
