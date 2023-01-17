package org.popcorn.service;

import org.popcorn.dao.MemberDAO;
import org.popcorn.domain.CatVO;
import org.popcorn.domain.MemberVO;
import org.popcorn.mappers.AdminMapper;
import org.popcorn.mappers.MemberMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminMapper mapper;


	@Override
	public List<CatVO> cat() throws Exception {
		return mapper.cat();
	     }
	}


