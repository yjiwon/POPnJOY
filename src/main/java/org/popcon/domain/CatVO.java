package org.popcon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatVO {


	private String catName;
	private String catCode;
	private String catCodeRef;

}
