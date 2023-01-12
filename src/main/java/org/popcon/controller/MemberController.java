package org.popcon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.popcon.domain.MemberVO;
import org.popcon.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/pos/*")
public class MemberController {


    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService service ;
    BCryptPasswordEncoder passEncoder;

    @ResponseBody
    @GetMapping("/signin")
    public void getSignin(MemberVO vo, HttpServletRequest request) throws Exception {
        logger.info("login......");


    }

    @PostMapping("/signin")
    public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
        logger.info("post signin");

        MemberVO login = service.signin(vo);
        HttpSession session = req.getSession();

        boolean passMatch = passEncoder.matches(vo.getUserPw(), login.getUserPw());  // db의 비밀번호와 입력된 비번 비교함

        if(login != null && passMatch) {
            session.setAttribute("member", login); // 아이디와 비밀번호 맞으면 멤버세션에 로그인 정보를 부여한다
        } else {
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", false);
            return "redirect:/pos/main";
        }

        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/signout")
    public String signout(HttpSession session) throws Exception {
        logger.info("logout.....");

        service.signout(session);

        return "redirect:/";
    }

}



