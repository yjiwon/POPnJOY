package org.popcorn.service;

import org.popcorn.dao.MemberDAO;
import org.popcorn.domain.MemberVO;

import org.popcorn.mappers.MemberMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return mapper.signin(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}
}