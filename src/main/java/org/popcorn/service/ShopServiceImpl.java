package org.popcorn.service;

import org.popcorn.domain.GoodsVO;
import org.popcorn.mappers.ShopMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

	private ShopMapper mapper;

	@Override
	public List<GoodsVO> list() throws Exception {
		return mapper.list();
	}
}