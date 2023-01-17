package org.popcorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatVO {


	private String catName;
	private String catCode;
	private String catCodeRef;
	private int level;

}
