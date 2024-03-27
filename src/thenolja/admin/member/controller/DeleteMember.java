package thenolja.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import thenolja.admin.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/deleteMember.do")
public class DeleteMember extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int memNo = Integer.parseInt(request.getParameter("memNo"));
      
      int result = new MemberService().deleteMember(memNo);
      
      JSONObject obj = new JSONObject();
      
      obj.put("message", "삭제 성공!");
         
      response.setContentType("application/json; charset=UTF-8");
      
      response.getWriter().print(obj.toString());
      
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}