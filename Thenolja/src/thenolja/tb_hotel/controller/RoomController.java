package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
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
			
			int hotelNo2 = 0;
			int maxPeople2 = 0;
			int roomPrice2 = 0;
			int roomNum2 = 0;
			String roomName2 = "";
			String inTime2 = "";
			String outTime2 = "";
			
			if(multiRequest.getParameter("roomName2") != null) {
				hotelNo2 = Integer.parseInt(multiRequest.getParameter("hotelNo"));
				maxPeople2 = Integer.parseInt(multiRequest.getParameter("maxPeople2"));
				roomPrice2 = Integer.parseInt(multiRequest.getParameter("roomPrice2"));
				roomNum2 = Integer.parseInt(multiRequest.getParameter("roomNum2"));
				roomName2 = multiRequest.getParameter("roomName2");
				inTime2 = multiRequest.getParameter("in_time2");
				outTime2 = multiRequest.getParameter("out_time2");
			}
			
			System.out.println(maxPeople);
			System.out.println(roomName);
			System.out.println(roomName2);
			System.out.println(maxPeople2);
			// VO담기
			ArrayList<Room> rList = new ArrayList();
			for(int i = 0; i < rList.size(); i++) {
				Room r = new Room();
				r.setHotelNo(hotelNo);
				r.setRoomName(roomName);
				r.setMaxPeople(maxPeople);
				r.setCheckInTime(inTime);
				r.setCheckOutTime(outTime);
				r.setRoomPrice(roomPrice);
				r.setRoomNum(roomNum);
				
				rList.add(r);
			}
			
			// System.out.println(rList);
			
			
			// 사진 roomImg
			//if(multiRequest.getOriginalFileName("roomImg") != null) {
				//h.setHotelPath("resources/hotelImage/"+ multiRequest.getFilesystemName("roomImg"));
			//}
			
			
		}
	
		
		view="/";

		return view;		
	}
}
