package org.popcorn.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.popcorn.domain.GoodsVO;
import org.popcorn.service.ShopService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/goods/")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService service ;

    //view = list
    @GetMapping("/list")
    public void getList(Model model) throws Exception {
        logger.info("get shop list...");

        List<GoodsVO> list = service.list();

        model.addAttribute("list", list);

    }
        @GetMapping("/list/view")
        public void getView(@RequestParam("n") int gdsId, Model model) throws Exception {
            logger.info("get shop view...");

            GoodsVO view = service.goodsView(gdsId);
          //  model.addAttribute("view", view);

        }


        //카트담기


        //주문하기


    }







