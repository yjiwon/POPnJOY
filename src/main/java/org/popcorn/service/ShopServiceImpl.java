package org.popcorn.service;

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
	public List<GoodsVO> list() throws Exception {
		return mapper.list();
	}

		public GoodsVO goodsView(int gdsId) throws Exception {
			return mapper.goodsView(gdsId);
		}
	}
