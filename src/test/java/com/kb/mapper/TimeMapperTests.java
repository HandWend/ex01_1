package com.kb.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 필수요소(1)
@RunWith(SpringJUnit4ClassRunner.class)
// mybatis 스캔한 거 넣어놓은 부분, 필수요소 (3)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	// 버전 올라가면서 _ 추가
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	// test하기 위해 anotation 사용, 필수요소 (2)
	
	public void testGetTime() {
		//timeMapper의 getTime()이란 메소드를 테스트해보겠다.
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info(timeMapper.getTime2());
	}
	
}
