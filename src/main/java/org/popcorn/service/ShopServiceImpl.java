package org.popcorn.service;

import org.popcorn.domain.CartVO;
import org.popcorn.domain.GoodsVO;
import org.popcorn.mappers.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {


	@Autowired
	ShopMapper mapper;

	@Override
	public List<GoodsVO> list(String gdsCat) throws Exception {
		return mapper.list(gdsCat);
	}

	@Override
	public GoodsVO goodsView(int gdsId) throws Exception {
			return mapper.goodsView(gdsId);
		}
	@Override
	public void addCart(CartVO cart) throws Exception {
		mapper.addCart(cart);

	  }
	}
