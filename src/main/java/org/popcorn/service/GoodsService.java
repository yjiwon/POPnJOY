package org.popcorn.service;

import org.popcorn.domain.MemberVO;

import javax.servlet.http.HttpSession;

public interface GoodsService {
	public MemberVO signin(MemberVO vo) throws Exception;

	public void signout(HttpSession session) throws Exception;

}
