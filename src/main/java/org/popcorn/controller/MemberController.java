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
@RequestMapping ("/member/*")
public class MemberController {


    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService service ;


    @GetMapping("/signin")
    public void getSignin() throws Exception {
        logger.info("login......");

    }

    @PostMapping("/signin")
    public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
        logger.info("post login");


        MemberVO login = service.signin(vo);  // MemberVO형 변수 login에 로그인 정보를 저장
        HttpSession session = req.getSession(); // 현재 세션 정보를 가져온다.

        if(login == null) {
            session.setAttribute("member", null);   // 로그인에 실패하면 어떠한 값도 안넘어온다.
            rttr.addFlashAttribute("msg", false);
            return "redirect:/member/signin";
        } else {
            session.setAttribute("member", login);   // 성공하면 매퍼에 있는 쿼리문에 대한 결과가 넘어오게 된다.
            // 조건문을 이용해서 값이 있는지 확인 하고 이에 맞게 세션 member에 값을 넣어준다. 멤버에는 매퍼에 있는 쿼리문의 결과가 들어 있다.
        }

        return "redirect:/admin/index";
    }

    // 로그아웃
    @GetMapping("/signout")
    public String signout(HttpSession session) throws Exception {
        logger.info("logout.....");

        service.signout(session); //세션정보제거

        return "redirect:/";
    }

}



