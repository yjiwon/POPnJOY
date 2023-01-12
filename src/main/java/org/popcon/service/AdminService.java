package org.popcon.service;

import org.popcon.domain.MemberVO;

import javax.servlet.http.HttpSession;

public interface AdminService {
	public MemberVO signin(MemberVO vo) throws Exception;

	public void signout(HttpSession session) throws Exception;

}
