package org.popcorn.service;

import org.popcorn.domain.CartVO;
import org.popcorn.domain.GoodsVO;

import java.util.List;

public interface ShopService {
	public List<GoodsVO> list(String gdsCat) throws Exception;

	public GoodsVO goodsView(int gdsId) throws Exception;

	public void addCart(CartVO cart) throws Exception;
}
