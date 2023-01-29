package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.CartListVO;
import org.popcorn.domain.CartVO;
import org.popcorn.domain.GoodsVO;


import java.util.List;


@Mapper
public interface ShopMapper {

	public List<GoodsVO> list(String gdsCat) throws Exception;

	public GoodsVO goodsView(int gdsId) throws Exception;

	// 카트 담기
	public void addCart(CartListVO cart) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(String name) throws Exception;

	// 카트 삭제
	public void deleteCart(CartVO cart) throws Exception;

	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;

	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	// 카트 비우기
	public void cartAllDelete(String name) throws Exception;

	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;


}
