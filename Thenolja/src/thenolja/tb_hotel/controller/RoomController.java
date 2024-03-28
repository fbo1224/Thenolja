package thenolja.tb_hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
		
		// 객실이 3개 이상이면 객실 추가 못함
		int roomCnt = new RoomService().countRoom(hotelNo);
		
		request.setAttribute("hotelNo", hotelNo);
		request.setAttribute("roomCnt", roomCnt);
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
	
	public String updateListForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		ArrayList<Room> rooms = new RoomService().updateRoomList(hotelNo);
		
		request.setAttribute("hotelNo", hotelNo);
		request.setAttribute("rooms", rooms);
		
		view = "views/hotel/roomListForm.jsp";
		return view;
	}
	
	public String updateRoomForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		System.out.println(roomNo);
		Room r = new RoomService().updateRoomForm(roomNo);
		
		if(r != null) {
			request.setAttribute("roomNo", roomNo);
			request.setAttribute("room", r);
			view = "views/hotel/updateRoomForm.jsp";
		} else {
			request.setAttribute("errorMsg", "객실 정보 가져오기 실패...");
			view = "views/common/errorPage.jsp";
		}
		
		return view;
	}
	
	public String updateRoom(HttpServletRequest request, HttpServletResponse response) {
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
			
			int roomNo = Integer.parseInt(multiRequest.getParameter("roomNo"));
			int maxPeople = Integer.parseInt(multiRequest.getParameter("maxPeople"));
			int roomPrice = Integer.parseInt(multiRequest.getParameter("roomPrice"));
			int roomNum = Integer.parseInt(multiRequest.getParameter("roomNum"));
			int roomImgNo = Integer.parseInt(multiRequest.getParameter("roomImgNo"));
			String roomName = multiRequest.getParameter("roomName");
			String inTime = multiRequest.getParameter("in_time");
			String outTime = multiRequest.getParameter("out_time");
			String roomImgBefore = multiRequest.getParameter("roomImgBefore"); 
			
			System.out.println("roomImgBefore : " + roomImgBefore);
			
			// VO담기
			Room r = new Room();
			r.setRoomNo(roomNo);
			r.setRoomName(roomName);
			r.setMaxPeople(maxPeople);
			r.setCheckInTime(inTime);
			r.setCheckOutTime(outTime);
			r.setRoomPrice(roomPrice);
			r.setRoomNum(roomNum);
			r.setRoomImgPath(roomImgBefore);
			r.setRoomImgNo(roomImgNo);
			
			String beforeImgName = roomImgBefore.substring(r.getRoomImgPath().lastIndexOf("/") + 1);
			
			// 사진 roomImg
			if(multiRequest.getOriginalFileName("roomImg") != null) {
				r.setRoomImgPath("resources/roomImage/"+ multiRequest.getFilesystemName("roomImg"));
				new File(savePath + "/" + beforeImgName).delete();
			}
			
			result = new RoomService().updateRoom(r);
		}
		
		if(result > 0) {
			view = "/hotelList.hotels?currentPage=1";
		} else {
			request.setAttribute("errorMsg", "객실정보 수정에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		
		return view;
	}
	
	public String deleteListForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		// 등록된 객실 보여주는것 update와 동일해서 재활용 
		ArrayList<Room> rooms = new RoomService().updateRoomList(hotelNo);
		
		request.setAttribute("hotelNo", hotelNo);
		request.setAttribute("rooms", rooms);
		
		view = "views/hotel/deleteListForm.jsp";
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
