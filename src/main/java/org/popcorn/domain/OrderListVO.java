package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderListVO {

	private String orderId;
	private String name;
	private String orderRec;
	private String orderPhone;
	private int amount;
	private Date orderDate;

}
