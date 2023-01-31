package org.popcorn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.popcorn.domain.MemberVO;
import org.popcorn.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/pos/*")
public class MemberController {


    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService service ;
    // BCryptPasswordEncoder passEncoder;


    @GetMapping("/signin")
    public void getSignin(MemberVO vo, HttpServletRequest request) throws Exception {
        logger.info("login......");


    }

    @PostMapping("/signin")
    public String login(MemberVO vo, HttpServletRequest req) throws Exception {
        logger.info("post login");

        HttpSession session = req.getSession();

        MemberVO login = service.signin(vo);

        if(login == null) {
            session.setAttribute("member", null);
        } else {
            session.setAttribute("member", login);
        }

        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/signout")
    public String signout(HttpSession session) throws Exception {
        logger.info("logout.....");

        service.signout(session); //세션정보제거

        return "redirect:/";
    }

}



