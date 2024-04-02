package thenolja.member.model.service;

import java.sql.Connection;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.dao.MemberDao;
import thenolja.member.model.vo.Member;

public class MemberService {
	
//-------------------로그인----------------------------
	public Member login(String memId, String memPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member loginUser = new MemberDao().login(conn, memId, memPwd);
		
		JDBCTemplate.close(conn);
		
		return loginUser;
		
	}
	
//----------------- 회원가입 ---------------------------------
	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, member);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);;
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
//-----------------------------아이디 중복확인-----------------------
	public int idCheck(String checkId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//---------------------------------정보수정-----------------------------
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		// nonmem테이블
		int noMemberResult = new MemberDao().updateNoMember(conn, member);
		
		// member테이블
		int memberResult = new MemberDao().updateMember(conn, member);
					
		if(noMemberResult * memberResult > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		int result = noMemberResult * memberResult;
		
		return result;
	}
//-------------------------------회원탈퇴---------------------------------------
	public int delete(int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().delete(conn, memNo);
		
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
//-----------------------------------아이디 찾기-----------------------------
	public Member findId(String memName, String bornDate, String email) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member findId = new MemberDao().findId(conn, memName, bornDate, email);
		
		JDBCTemplate.close(conn);
		
		return findId;
	}
//------------------------------------비밀번호 찾기(조회)----------------------
	public int findPwd(String memId, String bornDate, String memPhone) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().findPwd(conn,  memId, bornDate, memPhone);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
//------------------------------------비밀번호 찾기(재설정)---------------------------
	public int resetPwd(String memId, String memPwd ) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().resetPwd(conn, memId, memPwd);
					
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
//----------------------------------------회원등급 조회-------------------------------
	public String selectGrade(int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new MemberDao().selectGrade(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Member selectMember(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member member = new MemberDao().selectMember(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}

//--------------------------------닉네임 중복확인-----------------------------------
	public int nickNameCheck(String checkNickname) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().nickNameCheck(conn, checkNickname);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//------------------------------------이메일 중복확인---------------------------------
	public int emailCheck(String checkEmail) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().emailCheck(conn, checkEmail);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//------------------------------------찜 목록 추가----------------------------------------
	public int heartInsert(int hotelNo, int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().heartInsert(conn, hotelNo, memNo);
		
		if(count > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//-------------------------------------찜 목록 삭제---------------------------------------
	public int heartDelete(int hotelNo, int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().heartDelete(conn, hotelNo, memNo);
		
		if(count > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//-----------------------------------숙소상세조회페이지 로그인 사용자 찜목록 확인-----------------------------
	public int selectHeart(int hotelNo, int memNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().selectHeart(conn, hotelNo, memNo);
		
		if(count > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		System.out.println("selectHeart Servlet");
		JDBCTemplate.close(conn);
		
		return count;
	
		
	}
	
}
