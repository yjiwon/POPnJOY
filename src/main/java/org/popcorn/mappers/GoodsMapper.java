package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.MemberVO;


@Mapper
public interface GoodsMapper {
	public MemberVO (MemberVO vo) throws Exception;


}
