package org.popcon.dao;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.popcon.domain.MemberVO;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Repository
@RequiredArgsConstructor
public class MemberDAOlmpl implements MemberDAO {

	private SqlSession sql;
	private static String namespace = "com.popcon.mappers.MemberMapper";

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".signin", vo);
	}
	}
