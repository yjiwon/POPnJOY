package org.popcorn.service;

import org.popcorn.domain.GoodsVO;

import java.util.List;

public interface ShopService {
	public List<GoodsVO> list() throws Exception;

	public GoodsVO goodsView(int gdsId) throws Exception;
}
