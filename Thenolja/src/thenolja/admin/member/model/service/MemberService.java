package thenolja.admin.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.member.model.dao.MemberDao;
import thenolja.admin.member.model.vo.AdminMember;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;


public class MemberService {
	
	/**
	 * 페이징
	 * @return
	 */
	
	public int selectListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<AdminMember> selectMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().selectMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;	
		
	}
	
	
	public AdminMember selectMember(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMember member = new MemberDao().selectMember(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	
	
	/**
	 * 
	 *삭제
	 */
	public int deleteMember(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, memNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	/**
	 * 탈퇴 회원 수
	 */
	
	public int selectDeleteCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().selectDeleteCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}
	
	/**
	 * 탈퇴 회원 목록
	 */
	public ArrayList<AdminMember> selectDeleteMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().selectDeleteMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 탈퇴 회원 삭제
	 */
	public int completeDelete(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().completeDelete(conn, memNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 등급 수정
	 */
	public int updateGrade(AdminMember adminMember) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateGrade(conn, adminMember);
		
		System.out.println(adminMember);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	/**
	 * 멤버 아이디로 검색
	 */
	public AdminMember selectMemberId(String keyword) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMember adminMember = new MemberDao().selectMemberId(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return adminMember;
		
	}
	
	/**
	 * 탈퇴 멤버 아이디로 검색
	 */
	public AdminMember selectDeleteMemberId(String keyword) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMember adminMember = new MemberDao().selectDeleteMemberId(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return adminMember;
	}
	
	/**
	 * 가입자 수
	 */
	public int countJoinMember() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().countJoinMember(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 오래된 순으로 정렬
	 */
	public ArrayList<AdminMember> memberOldestList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().memberOldestList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 탈퇴회원 오래된 순으로 정렬
	 */
	public ArrayList<AdminMember> oldDeleteMemberList(PageInfo pi){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().oldDeleteMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 오늘 가입자 정보
	 */
	public ArrayList<AdminMember> todayJoinDetail(){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminMember> list = new MemberDao().todayJoinDetail(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
