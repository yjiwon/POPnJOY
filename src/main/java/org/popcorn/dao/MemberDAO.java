package org.popcorn.dao;

import org.popcorn.domain.MemberVO;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberDAO {

	public MemberVO signin(MemberVO vo) throws Exception;

}
