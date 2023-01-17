package org.popcorn.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.popcorn.domain.MemberVO;

import org.springframework.stereotype.Repository;

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
