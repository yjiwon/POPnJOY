package org.popcorn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.GoodsVO;
import org.popcorn.domain.OrderListVO;
import org.popcorn.domain.OrderVO;

import java.util.List;


@Mapper
public interface AdminMapper {

	// 상품등록
	public void register(GoodsVO vo) throws Exception;

	// 상품목록
	public List<GoodsVO> goodsList() throws Exception;

	// 상품조회  + 카테고리 조인
	public GoodsVO goodsView(int gdsId) throws Exception;

	// 상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;

	// 상품 삭제
	public void goodsDelete(int gdsId) throws Exception;

	// 주문 목록
	public List<OrderVO> orderList() throws Exception;

	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;

	// 상품 수량 조절
	public void changeStock(GoodsVO goods) throws Exception;

	// 수령 상태
	public void delivery(OrderVO order) throws Exception;

	//수령 후 지우기
	public void orderDelete(String orderId) throws Exception;




}
