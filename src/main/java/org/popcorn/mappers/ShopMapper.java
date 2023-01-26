package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.GoodsVO;


import java.util.List;


@Mapper
public interface ShopMapper {

	public List<GoodsVO> list() throws Exception;


}