package org.popcon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.popcon.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



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
    @GetMapping("/register")
        public void getGoodsRegister() throws Exception {
            logger.info("register............");

        }

    }







