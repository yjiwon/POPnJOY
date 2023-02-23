package org.popcorn.service;

import org.popcorn.domain.*;

import java.io.IOException;
import java.util.List;

public interface ShopService {
	public List<GoodsVO> list(String gdsCat) throws Exception;

	public GoodsVO goodsView(int gdsId) throws Exception;

	// 카트 담기
	public void addCart(CartListVO cart) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(CartListVO cart) throws Exception;

	// 카트 삭제
	public void deleteCart(CartVO cart) throws Exception;


	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;

	public List<OrderVO> orderInfoList(OrderVO order) throws Exception;

	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	public OrderVO orderRead(String orderId) throws Exception;

	// 카트 비우기
	public void cartAllDelete(String orderId) throws Exception;

	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;

	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;

	String getToken() throws IOException;

	public interface PaymentService {

		String getToken() throws IOException;

		int paymentInfo(String imp_uid, String access_token);

		public void payMentCancle(String access_token, String imp_uid, String amount, String reason);

	}




}
