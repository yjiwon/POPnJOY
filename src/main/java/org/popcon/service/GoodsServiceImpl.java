package org.popcon.service;

import lombok.AllArgsConstructor;
import org.helpme.mapper.MemberMapper;
import org.popcon.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
//@Configuration
//@MapperScan("org.yuni.mapper")
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private MemberMapper memberMapper;
	private JavaMailSender mailSender;


	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return null;
	}

	@Override
	public void signout(HttpSession session) throws Exception {

	}
}