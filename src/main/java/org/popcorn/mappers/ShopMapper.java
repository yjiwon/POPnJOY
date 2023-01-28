package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.CartVO;
import org.popcorn.domain.GoodsVO;


import java.util.List;


@Mapper
public interface ShopMapper {

	public List<GoodsVO> list(String gdsCat) throws Exception;

	public GoodsVO goodsView(int gdsId) throws Exception;
	public void addCart(CartVO cart) throws Exception;


}
