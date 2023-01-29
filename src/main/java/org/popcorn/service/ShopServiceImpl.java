package org.popcorn.service;

import org.popcorn.domain.CartListVO;
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
	// 카트 담기
	@Override
	public void addCart(CartListVO cart) throws Exception {
		mapper.addCart(cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String name) throws Exception {
		return mapper.cartList(name);
	}

	// 카트 삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		mapper.deleteCart(cart);
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
	public void cartAllDelete(String name) throws Exception {
		mapper.cartAllDelete(name);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return mapper.orderList(order);
	}


}

