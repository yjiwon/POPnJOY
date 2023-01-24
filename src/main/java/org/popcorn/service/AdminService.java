package org.popcorn.service;

import org.popcorn.domain.CatVO;
import org.popcorn.domain.GoodsVO;
import org.popcorn.domain.GoodsViewVO;

import java.util.List;

public interface AdminService {

	// 상품등록
	public void register(GoodsVO vo) throws Exception;

	// 상품목록
	public List<GoodsViewVO> goodsList() throws Exception;

	// 상품조회  + 카테고리 조인
	public GoodsViewVO goodsView(int gdsId) throws Exception;

	// 상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;

	// 상품 삭제
	public void goodsDelete(int gdsId) throws Exception;

}
