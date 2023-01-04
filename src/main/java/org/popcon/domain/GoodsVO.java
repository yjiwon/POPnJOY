package org.popcon.domain;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsVO {

	private int gdsId;
	private String gdsName;
	private String gdsCat;
	private int gdsPrice;
	private int gdsStock;
	private String gdsDes;
	private String gdsImage;
	private Date gdsDete;

}
