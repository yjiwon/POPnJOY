package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVO {

	private String orderId;
	private String orderPhone;
	private int amount;
	private Date orderDate;

}
