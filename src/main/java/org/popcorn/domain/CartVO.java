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
    private String name; //비회원 이름 입력
	private int CartStock;



}
