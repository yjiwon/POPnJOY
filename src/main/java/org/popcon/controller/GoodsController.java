package org.popcon.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.popcon.service.GoodsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/goods/*")
public class GoodsController {

    private final GoodsService service ;

    @GetMapping("/list")
    public void list(Model model){

        log.info("list............." );

        model.addAttribute("list",list);

        return "/goods/list";
       

    }
}



