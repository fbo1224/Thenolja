package com.kh.thenolja.tb_review.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.thenolja.common.model.vo.PageInfo;
import com.kh.thenolja.tb_review.model.service.ReviewService;
import com.kh.thenolja.tb_review.model.vo.Review;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/reviewList")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ReviewListController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int listCount; 
		int currentPage; 
		int pageLimit; 
		int reviewLimit;
		
		int maxPage;
		int startPage; 
		int endPage; 
		
		listCount = new ReviewService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		
		reviewLimit = 10;
		

		maxPage = (int)Math.ceil((double)listCount / reviewLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, reviewLimit,
								   maxPage, startPage, endPage);	
		
	
		ArrayList<Review> boardList = new ReviewService().selectList(pi);
		
		
		request.setAttribute("reviewList", reviewLimit);
		request.setAttribute("pageInfo", pi);
		
		request.getRequestDispatcher("views/tb_review/reviewList.jsp").forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
