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

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/goods/*")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService service ;

    @GetMapping("/list")
    public void getList(Model model) throws Exception {
        logger.info("get shop list...");
        //	logger.info(cri.toString());

        List<GoodsVO> list = service.list();

        //	model.addAttribute("list", adminMemberService.listSearchCriteria(cri));
        model.addAttribute("list", list);


    }


    }




