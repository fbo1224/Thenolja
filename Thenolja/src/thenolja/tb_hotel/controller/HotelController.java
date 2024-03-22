package thenolja.tb_hotel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
import thenolja.tb_hotel.model.vo.Hotel;

public class HotelController {

	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view="views/hotel/insertHotel.jsp";
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		if(ServletFileUpload.isMultipartContent(request)) {
			// letterNo 우편번호
			// loadName 도로명주소
			// detailAddr 상세주소
			// hotelCate 숙소종류
			// hotelName 호텔이름
			// phone1 == 010 /전화번호
			// phone2 == xxxxxxxx
			// serList 서비스 리스트 
			// introText 소개말
			// hotelImg 대표사진
			String savePath = request.getServletContext()
			         .getRealPath("/resources/hotelImage");
			
			int maxSize = 1024 * 1024 * 10;
			MultipartRequest multiRequest = null;
			try {
				multiRequest =
						new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String letterNo = multiRequest.getParameter("letterNo");
			String loadName = multiRequest.getParameter("loadName");
			String detailAddr = multiRequest.getParameter("detailAddr");
			String hotelCate = multiRequest.getParameter("hotelCate");
			String hotelName = multiRequest.getParameter("hotelName");
			String ceoName = multiRequest.getParameter("ceoName");
			String phone1 = multiRequest.getParameter("phone1");
			String phone2 = multiRequest.getParameter("phone2");
			String[] serList = multiRequest.getParameterValues("serList");
			String introText = multiRequest.getParameter("introText");
			
			// hotelImg 파일
			
//			System.out.println(letterNo);
//			System.out.println(loadName);
//			System.out.println(detailAddr);
//			System.out.println(hotelCate);
//			System.out.println(hotelName);
//			System.out.println(phone1+phone2);
			// System.out.println(String.join(",", serList)); 여기 옵션아님
//			System.out.println(introText);
			
			// 지역뽑기
			String location = loadName.substring(0, loadName.indexOf(" ")+1);
			
			// 지역을 제외한 
			String newlocation = loadName.substring(loadName.indexOf(" ")+1);
			
			Hotel h = new Hotel();
			h.setHotelName(hotelName);
			h.setHotelPhone(phone1+phone2);
			h.setHotelLocation(location); // 지역
			h.setHotelAddress(newlocation + detailAddr);
			h.setHotelCategory(hotelCate);
			h.setHotelIntro(introText);
			h.setHostName(ceoName);
			
			if(multiRequest.getOriginalFileName("hotelImg") != null) {
				h.setHotelPath("/resources/hotelImage"+multiRequest.getFilesystemName("hotelImg"));
			}
			
			System.out.println(h);
			view="/";
		}
		return view;
		
	}
	
	
	public String hotelList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view = "views/hotel/hotelList.jsp";
		return view;
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		
		return view;
	}
	
	
	public String select(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view = "views/hotel/hotelDetail.jsp";
		return view;
	}
}
