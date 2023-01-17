package org.popcorn.service;

import lombok.AllArgsConstructor;
import org.popcorn.domain.MemberVO;
import org.popcorn.mappers.GoodsMapper;

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