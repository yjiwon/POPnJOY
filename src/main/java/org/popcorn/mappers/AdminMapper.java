package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.CatVO;
import org.popcorn.domain.GoodsVO;
import org.popcorn.domain.GoodsViewVO;
import org.popcorn.domain.MemberVO;

import java.util.List;


@Mapper
public interface AdminMapper {

	// 상품등록
	public void register(GoodsVO vo) throws Exception;

	// 상품목록
	public List<GoodsViewVO> goodslist() throws Exception;

	// 상품조회  + 카테고리 조인
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	// 상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;

	// 상품 삭제
	public void goodsDelete(int gdsNum) throws Exception;



}
