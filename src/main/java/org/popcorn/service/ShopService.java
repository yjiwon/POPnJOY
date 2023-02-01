package org.popcorn.service;

import org.popcorn.domain.*;

import java.util.List;

public interface ShopService {
	public List<GoodsVO> list(String gdsCat) throws Exception;

	public GoodsVO goodsView(String gdsCat) throws Exception;

	// 카트 담기
	public void addCart(CartListVO cart) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(int cartNum) throws Exception;

	// 카트 삭제
	public void deleteCart(int gdsId) throws Exception;

	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;

	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	// 카트 비우기
	public void cartAllDelete(String orderId) throws Exception;

	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;

	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;



}
