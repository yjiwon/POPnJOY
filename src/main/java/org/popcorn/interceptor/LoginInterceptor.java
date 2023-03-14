package org.popcorn.interceptor;

import org.popcorn.domain.MemberVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res, Object obj) throws Exception {

        HttpSession session = req.getSession();
        MemberVO member = (MemberVO)session.getAttribute("member");

        if(member == null) {
            res.sendRedirect("/member/signin");
            return false;
        }

        return true;
    }
}
