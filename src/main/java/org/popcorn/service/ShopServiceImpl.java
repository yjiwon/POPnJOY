package org.popcorn.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.popcorn.domain.*;
import org.popcorn.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {


	@Autowired
	ShopMapper mapper;
	@Value("${imp_key}")
	private String impKey;

	@Value("${imp_secret}")
	private String impSecret;


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
	public void deleteCart(CartVO cart) throws Exception {
		mapper.deleteCart(cart);
	}

	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		mapper.orderInfo(order);
    }

	public List<OrderVO> orderInfoList(OrderVO order) throws Exception {
		return mapper.orderInfoList(order);

	}

	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		mapper.orderInfo_Details(orderDetail);
	}
	@Override
	public OrderVO orderRead(String orderId) throws Exception {
		return mapper.orderRead(orderId);

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


	@Override
	public String getToken() throws IOException {

		HttpsURLConnection conn = null;

		URL url = new URL("https://api.iamport.kr/users/getToken");

		conn = (HttpsURLConnection) url.openConnection();

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		JsonObject json = new JsonObject();

		json.addProperty("imp_key", impKey);
		json.addProperty("imp_secret", impSecret);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

		bw.write(json.toString());
		bw.flush();
		bw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

		Gson gson = new Gson();

		String response = gson.fromJson(br.readLine(), Map.class).get("response").toString();

		System.out.println(response);

		String token = gson.fromJson(response, Map.class).get("access_token").toString();

		br.close();
		conn.disconnect();

		return token;
	}

	public int paymentInfo(String imp_uid, String access_token) {

		return 0;
	}



	public void payMentCancle(String access_token, String imp_uid, String amount, String reason)  {


	}


	}



