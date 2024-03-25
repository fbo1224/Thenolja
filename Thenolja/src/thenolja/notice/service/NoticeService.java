package thenoleja.notice.service;

import java.util.ArrayList;
import java.util.List;

import thenoleja.notice.model.vo.Notice;

public interface NoticeService {

	//공지사항목록 조회(R)*
	ArrayList <Notice> selectNoticeList();
	
	//공지사항상세 조회(R)*
	Notice selectNotice(int noticeNo); //정수값 들오감
	//공지사항 작성
	
	//공지사항 수정,삭제
	
	
}//method  인터페이스 특징 : 강제성 이 있다. 추상메소드,반환타입,식별자가 없다   ⁕반환형 메소드식별자(매개변수);
