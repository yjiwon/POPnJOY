package org.popcon.service;

import lombok.AllArgsConstructor;
import org.helpme.domain.AccountInfoVO;
import org.helpme.domain.MemberVO;
import org.helpme.domain.ServiceVO;
import org.helpme.dto.LoginDTO;
import org.helpme.dto.ReviewDTO;
import org.helpme.mapper.MemberMapper;
import org.popcon.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Service
//@Configuration
//@MapperScan("org.yuni.mapper")
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

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