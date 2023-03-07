package org.popcorn.service;

import org.popcorn.domain.MemberVO;

import org.popcorn.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return mapper.signin(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate(); // 세션 정보를 제거함
	}
}