package org.popcorn.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.popcorn.domain.*;
import org.popcorn.util.MediaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.popcorn.service.ShopService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
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
    private final String uploadPath = "C:\\pop";

    //view = list

    @GetMapping("/index")
    public void getIndex() throws Exception {
        logger.info("index..........");

    }

    @GetMapping("/list")
    public void getList(@RequestParam("c") String gdsCat, Model model) throws Exception {
        logger.info("get shop list...");

        List<GoodsVO> list = service.list(gdsCat); // GoodsVO형태의 List형 변수 list 선언

        model.addAttribute("list", list); // 변수 list의 값을 list 세션에 부여

    }

    @GetMapping("/list/view")
    public void getView(@RequestParam("n") int gdsId, Model model) throws Exception {
        logger.info("get shop view...");

        GoodsVO view = service.goodsView(gdsId);
        model.addAttribute("view", view);

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


    @ResponseBody
    @GetMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        logger.info("FILE NAME: " + fileName);

        try {

            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

            MediaType mType = MediaUtils.getMediaType(formatName);

            HttpHeaders headers = new HttpHeaders();

            in = new FileInputStream(uploadPath + "/" + fileName);

            if (mType != null) {
                headers.setContentType(mType);
            } else {

                fileName = fileName.substring(fileName.indexOf("_") + 1);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.add("Content-Disposition",
                        "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
            System.out.println("entity=" + entity);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }
    
    
    

    //카트담기

    @ResponseBody
    @PostMapping("/list/addCart")
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
    public void getCartList(int cartNum, RedirectAttributes rttr,  Model model) throws Exception {
        logger.info("get cart list");

        List<CartListVO> cartList = service.cartList(cartNum);  // CartListVO형태 변수 CartList에 상품 정보 저장
        model.addAttribute("cartList", cartList);

        rttr.addFlashAttribute("msg", "SUCCESS");
    }


    @PostMapping("/deleteCart")
    public String PostDeleteCart(@RequestParam(value = "n") int gdsId) throws Exception {
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

    // 주문 목록
    @GetMapping("/orderList")
    public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception {
        logger.info("get order list");


        List<OrderVO> orderList = service.orderList(order);

        model.addAttribute("orderList", orderList);
    }

    // 주문 상세 목록
    @GetMapping("/orderView")
    public void getOrderList(HttpSession session,
                             @RequestParam("n") String orderId,
                             OrderVO order, Model model) throws Exception {
        logger.info("get order view");


        order.setOrderId(orderId);

        List<OrderListVO> orderView = service.orderView(order);

        model.addAttribute("orderView", orderView);
    }




}
