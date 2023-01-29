package org.popcorn.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.popcorn.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.popcorn.service.ShopService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/goods/*")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService service;

    //view = list
    @GetMapping("/list2")
    public void getList(@RequestParam(required = false, name = "c") String gdsCat, Model model) throws Exception {
        logger.info("get shop list...");

        List<GoodsVO> list = null;
        list = service.list(gdsCat);

        model.addAttribute("list", list);

    }

    @GetMapping("/list2/view")
    public void getView(@RequestParam("n") int gdsId, Model model) throws Exception {
        logger.info("get shop view...");

        GoodsVO view = service.goodsView(gdsId);
        //  model.addAttribute("view", view);

    }

  /*

  @ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply,  HttpSession session) throws Exception {
		logger.info("post delete reply");

		// 정상작동 여부를 확인하기 위한 변수
		int result = 0;

		MemberVO member = (MemberVO)session.getAttribute("member");  // 현재 로그인한  member 세션을 가져옴
		String userId = service.idCheck(reply.getRepNum());  // 소감(댓글)을 작성한 사용자의 아이디를 가져옴

		// 로그인한 아이디와, 소감을 작성한 아이디를 비교
		if(member.getUserId().equals(userId)) {

			// 로그인한 아이디가 작성한 아이디와 같다면

			reply.setUserId(member.getUserId());  // reply에 userId 저장
			service.deleteReply(reply);  // 서비스의 deleteReply 메서드 실행

			// 결과값 변경
			result = 1;
		}

		// 정상적으로 실행되면 소감 삭제가 진행되고, result값은 1이지만
		// 비정상적으로 실행되면 소감 삭제가 안되고, result값이 0
		return result;

   */



    //카트담기

    @ResponseBody
    @PostMapping("/list2/addCart")
    public int addCart(CartListVO cart, HttpSession session) throws Exception {

        int result = 0; //정상 작동 여부를 확인하기 위한 변수

        if (cart != null) {
            cart.setCartNum(cart.getCartNum());
            service.addCart(cart);

            result = 1;    // 카트리스트가 채워져있으면 카트넘버에 저장시켜서 실행(?) 되려나..

        }

        return result;


    }

    @GetMapping("/cartList")
    public void getCartList(int cartNum, Model model) throws Exception {
        logger.info("get cart list");

        List<CartListVO> cartList = service.cartList(cartNum);

    }


    @PostMapping("/deleteCart")
    public String deleteCart(@RequestParam(value = "n") int gdsId) throws Exception {
        logger.info("delete cart");

        service.deleteCart(gdsId);

        return "redirect:/shop/cartList";

    }
    //주문하기
    @PostMapping("/order")
    public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
        logger.info("order");

        CartVO cart = (CartVO)session.getAttribute("cart");
        int carNum = cart.getCartNum();

        // 캘린더 호출
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);  // 연도 추출
        String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);  // 월 추출
        String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));  // 일 추출
        String subNum = "";  // 랜덤 숫자를 저장할 문자열 변수

        for(int i = 1; i <= 6; i ++) {  // 6회 반복
            subNum += (int)(Math.random() * 10);  // 0~9까지의 숫자를 생성하여 subNum에 저장
        }

        String orderId = ymd + "_" + subNum;  // [연월일]_[랜덤숫자] 로 구성된 문자

        order.setOrderId(orderId);
       //  order.setOrderPhone(orderPhone);

        service.orderInfo(order);

        orderDetail.setOrderId(orderId);
        service.orderInfo_Details(orderDetail);

        service.orderInfo(order);
        service.orderInfo_Details(orderDetail);

        service.cartAllDelete(orderId);

        return "redirect:/shop/orderList";
    }

}














