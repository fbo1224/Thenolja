package thenolja.admin.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.member.model.dao.MemberDao;
import thenolja.admin.member.model.vo.Member;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class MemberService {
   
   public int selectListCount() {
      
      Connection conn = JDBCTemplate.getConnection();
      
      int result = new MemberDao().selectListCount(conn);
      
      JDBCTemplate.close(conn);
      
      return result;
      
   }

   public ArrayList<Member> selectMemberList(PageInfo pi) {
      
      Connection conn = JDBCTemplate.getConnection();
      
      ArrayList<Member> list = new MemberDao().selectMemberList(conn, pi);
      
      JDBCTemplate.close(conn);
      
      return list;   
      
   }
   
   /*public Member selectIdMember(String memId) {
      
      Connection conn = JDBCTemplate.getConnection();
      
      Member member = new MemberDao().selectIdMember(conn, memId);
      
      JDBCTemplate.close(conn);
      
      return member;
      
   }*/
   
   public Member selectMember(int memNo) {
      
      Connection conn = JDBCTemplate.getConnection();
      
      Member member = new MemberDao().selectMember(conn, memNo);
      
      JDBCTemplate.close(conn);
      
      return member;
   }
   
   
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
   
   
   
   
   
}