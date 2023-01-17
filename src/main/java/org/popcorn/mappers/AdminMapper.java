package org.popcorn.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.popcorn.domain.CatVO;
import org.popcorn.domain.MemberVO;

import java.util.List;


@Mapper
public interface AdminMapper {

	public List<CatVO> cat() throws Exception;


}
