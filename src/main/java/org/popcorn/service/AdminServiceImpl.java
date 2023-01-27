package org.popcorn.service;


import org.popcorn.domain.GoodsVO;
import org.popcorn.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper mapper;

	@Override
	public void register(GoodsVO vo) throws Exception {
		mapper.register(vo);
	}

	// 상품목록
	@Override
	public List<GoodsVO> goodsList() throws Exception {
		return mapper.goodsList();
	}

	// 상품조회  + 카테고리 조인
	@Override
	public GoodsVO goodsView(int gdsId) throws Exception {
		return mapper.goodsView(gdsId);
	}

	// 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		mapper.goodsModify(vo);
	}

	// 상품 삭제
	@Override
	public void goodsDelete(int gdsId) throws Exception {
		mapper.goodsDelete(gdsId);
	}

	     }



