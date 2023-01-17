package org.popcorn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;

import org.popcorn.domain.CatVO;
import org.popcorn.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService service ;
    private final String uploadPath = "C:\\pop";

    @GetMapping("/index")
    public void getIndex() throws Exception {
        logger.info("index..........");

    }

    //등록
    @GetMapping("/register")
    public void getGoodsRegister(Model model) throws Exception {
            logger.info("register............");

        List<CatVO> cat = null;
        cat = service.cat();
        model.addAttribute("category", JSONArray.fromObject(cat));

        }

    }







