package org.popcon.service;

import org.popcon.domain.MemberVO;

import javax.servlet.http.HttpSession;

public interface MemberService {
	public MemberVO signin(MemberVO vo) throws Exception;

	public void signout(HttpSession session) throws Exception;

}
