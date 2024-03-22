package thenolja.admin.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailMember
 */
@WebServlet("/detailMember.do")
public class DetailMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		Member member = new MemberService().selectMember(boardNo)
	      
		
		// JSON
		// 자바타입 객체 => JSON타입의 객체로 가공
		/*
		JSONObject boardObj = new JSONObject();
		boardObj.put("boardTitle", board.getBoardTitle());
		boardObj.put("boardContent", board.getBoardContent());
		boardObj.put("count", board.getCount());
		*/
		
		
		response.setContentType("application/json; charset=UTF-8");
		// response.getWriter().print(boardObj); 
		
		// GSON : Google JSON 라이브러리
		
		// GSON객체 생성
		Gson gson = new Gson();
		
		// gson.toJson()
		// [ 표현법 ] gson.toJson(응답할객체, 응답할스트림);
		gson.toJson(list, response.getWriter());
		// => response.getWriter()라는 스트림으로 list라는 객체를 응답하겠다~~
		
		// 자동으로 키값이 전달하는 객체의 필드명이 됨!
		
		// VO객체 하나만 넘길 시 JSONObject{}형태로 만들어서 응답
		// List객체 응답 시 JSONArray[]형태로 만들어서 응답
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
