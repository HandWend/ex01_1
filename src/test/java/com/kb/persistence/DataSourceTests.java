package com.kb.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


//version up
@RunWith(SpringJUnit4ClassRunner.class)
//서버경로 잡아준 걸 잡아온다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	//Test가 붙어있는 곳만 테스트한다.
	@Test
	public void testMyBatis() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Connection conn = sqlSession.getConnection();
		log.info(conn);
	}
	
	@Test
	public void testConnection() {
		try {
			Connection conn= dataSource.getConnection();
			log.info(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
