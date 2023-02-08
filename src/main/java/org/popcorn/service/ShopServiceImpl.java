package org.popcorn.service;

import org.popcorn.domain.*;
import org.popcorn.mapper.ShopMapper;
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
		return mapper.goodsView (gdsId);
	}

	// 카트 담기
	@Override
	public void addCart(CartListVO cart) throws Exception {
		mapper.addCart(cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(CartListVO cart) throws Exception {
		return mapper.cartList(cart);
	}

	// 카트 삭제
	@Override
	public void deleteCart(int gdsId) throws Exception {
		mapper.deleteCart(gdsId);
	}

	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		mapper.orderInfo(order);
	}

	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		mapper.orderInfo_Details(orderDetail);
	}

	// 카트 비우기 
	@Override
	public void cartAllDelete(String orderId) throws Exception {
		mapper.cartAllDelete(orderId);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return mapper.orderList(order);
	}

		// 특정 주문
		@Override
		public List<OrderListVO> orderView (OrderVO order) throws Exception {
			return mapper.orderView(order);
		}


	}



