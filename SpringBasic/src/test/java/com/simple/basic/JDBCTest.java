package com.simple.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //본인이 동작시키고 싶은 스프링 설정파일
public class JDBCTest {
	
//	@BeforeClass //해당 클래스에서 단 한번 실행 - static(우선실행)
//	public static void loadTest() {
//		System.out.println("beforeClass");
//	}
//	
//	@Before //각 테스트 코드를 실행하기 전에 1번씩 우선실행
//	public void testCode00() {
//		System.out.println("before");
//	}
	
	@Autowired
	DataSource dataSource;
	
	@Test //test코드로 실행함
	public void testCode01() {
		
		try {
			//DataSource에서 conn객체 얻음
			Connection conn = dataSource.getConnection(); //connection객체를 담음
			
			System.out.println(conn);
			
		} catch (Exception e) {
			
		}
		
	}
	

	
	
	
}
