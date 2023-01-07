package org.popcon.service;

import lombok.AllArgsConstructor;
import org.popcon.domain.MemberVO;
import org.popcon.mappers.GoodsMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
//@Configuration
//@MapperScan("org.yuni.mapper")
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

	private GoodsMapper mapper;


	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return null;
	}

	@Override
	public void signout(HttpSession session) throws Exception {

	}
}