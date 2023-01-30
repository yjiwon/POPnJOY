package org.popcorn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.MemberVO;


@Mapper
public interface MemberMapper {

	public MemberVO signin(MemberVO vo) throws Exception;


}
