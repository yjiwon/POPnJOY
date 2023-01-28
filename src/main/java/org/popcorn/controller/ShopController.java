package org.popcorn.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.popcorn.domain.CartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.popcorn.domain.GoodsVO;
import org.popcorn.service.ShopService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/goods/")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService service ;

    //view = list
    @GetMapping("list2")
    public void getList(@RequestParam(required=false, name="c") String gdsCat,Model model) throws Exception {
        logger.info("get shop list...");

        List<GoodsVO> list = null;
        list = service.list(gdsCat);

        model.addAttribute("list", list);

    }
        @GetMapping("list2/view")
        public void getView(@RequestParam("n") int gdsId, Model model) throws Exception {
            logger.info("get shop view...");

            GoodsVO view = service.goodsView(gdsId);
          //  model.addAttribute("view", view);

        }


        //카트담기

    @ResponseBody
    @PostMapping("view/addCart")
    public void addCart(CartVO cart, HttpSession session) throws Exception {
        //  MemberVO member = (MemberVO)session.getAttribute("member");
        //   cart.setUserId(member.getUserId());

        service.addCart(cart);

    }



        //주문하기


    }







