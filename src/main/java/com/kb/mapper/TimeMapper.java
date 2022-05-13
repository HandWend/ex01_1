package com.kb.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select(" SELECT now() ")
	//getTime() 호출하면 현재 시간을 호출한다.
	//연-월-일-시-분-초
	public String getTime();
	
	//select문 없이 annotation 없이
	// getTime2()가 id가 된다.
	public String getTime2();
}
