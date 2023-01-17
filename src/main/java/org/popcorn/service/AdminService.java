package org.popcorn.service;

import org.popcorn.domain.CatVO;
import java.util.List;

public interface AdminService {

	public List<CatVO> cat() throws Exception;

}
