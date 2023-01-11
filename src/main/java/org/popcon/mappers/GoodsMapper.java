package org.popcon.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcon.domain.MemberVO;


@Mapper
public interface GoodsMapper {
	public MemberVO (MemberVO vo) throws Exception;


}
