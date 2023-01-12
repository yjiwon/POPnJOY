package org.popcon.service;

import org.popcon.dao.MemberDAO;
import org.popcon.domain.MemberVO;
import org.popcon.mappers.MemberMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements MemberService {

	private MemberMapper mapper;
	private MemberDAO dao;

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return mapper.signin(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}
}