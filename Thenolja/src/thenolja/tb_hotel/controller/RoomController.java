package thenolja.tb_hotel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
import thenolja.tb_hotel.model.service.RoomService;
import thenolja.tb_hotel.model.vo.Room;

public class RoomController {

	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		request.setAttribute("hotelNo", hotelNo);
		
		view= "views/hotel/insertRoom.jsp";
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int result = 0;
		if(ServletFileUpload.isMultipartContent(request)) {
			String savePath = request.getServletContext()
			         .getRealPath("/resources/roomImage");
			
			int maxSize = 1024 * 1024 * 10;
			
			MultipartRequest multiRequest = null;
			
			try {
				multiRequest =
						new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int hotelNo = Integer.parseInt(multiRequest.getParameter("hotelNo"));
			int maxPeople = Integer.parseInt(multiRequest.getParameter("maxPeople"));
			int roomPrice = Integer.parseInt(multiRequest.getParameter("roomPrice"));
			int roomNum = Integer.parseInt(multiRequest.getParameter("roomNum"));
			String roomName = multiRequest.getParameter("roomName");
			String inTime = multiRequest.getParameter("in_time");
			String outTime = multiRequest.getParameter("out_time");
			
			// VO담기
			Room r = new Room();
			r.setHotelNo(hotelNo);
			r.setRoomName(roomName);
			r.setMaxPeople(maxPeople);
			r.setCheckInTime(inTime);
			r.setCheckOutTime(outTime);
			r.setRoomPrice(roomPrice);
			r.setRoomNum(roomNum);
			
			// 사진 roomImg
			if(multiRequest.getOriginalFileName("roomImg") != null) {
				r.setRoomImgPath("resources/roomImage/"+ multiRequest.getFilesystemName("roomImg"));					
			}
			
			// System.out.println(r);
			
			result = new RoomService().insertRoom(r);
			
		}
		
		if(result > 0) {
			request.setAttribute("loginStatus", "A");
			view="/hotelList.hotels?currentPage=1";
		} else {
			request.setAttribute("errorMsg", "객실 추가에 실패했습니다.");
			view="views/common/errorPage.jsp";
		}
		return view;		
	}
}
