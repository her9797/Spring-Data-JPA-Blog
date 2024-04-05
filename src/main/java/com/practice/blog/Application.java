package com.practice.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/**  < 조건 >

 - 테이블 2개 사용			-> 블로그 본문 / 댓글
 - 연관 데이터만 있으면 됨		-> 본문의 댓글
 - 연관 관계일 필요까진 없음
 - 데이터 모델링해서 써도 되고
 - 세미 때 쓴 테이블 써도 되고
 - 엔티티로 설계해서 generate-ddl로 날려서 써도 됨

 < 필수 기능 >

 1. (테이블 1개 대상) 전체 조회 	 	-> 블로그 전체 목록 조회
 2. (테이블 1개 대상) 선택 조회		 	-> 블로그 상세 조회
 3. (테이블 1개 대상) 등록/수정/삭제 	-> 블로그 등록 수정 삭제
 4. 비동기 통신 (fetch 사용)			-> 블로그 당 댓글? fetch? 흠,,,
 5. 쿼리 메소드로 조건 조회

 */