package org.popcorn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetailVO {

	private int orderDetailsNum;
	private String orderId;
	private int gdsId;
	private Date cartStock;

}
