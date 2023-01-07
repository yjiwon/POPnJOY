package org.popcon.dao;

import org.popcon.domain.MemberVO;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberDAO {

	public MemberVO signin(MemberVO vo) throws Exception;

}
