package org.popcon.repository;

import org.apache.ibatis.annotations.Mapper;

import org.popcon.domain.MemberVO;


@Mapper
public interface MemberMapper {
	public MemberVO signin(MemberVO vo) throws Exception;


}
