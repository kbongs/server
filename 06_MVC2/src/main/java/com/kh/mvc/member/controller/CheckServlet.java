package com.kh.mvc.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mvc.member.model.service.MemberService;

@WebServlet("/member/idCheck")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService service = new MemberService();

    public CheckServlet() {
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ID 값을 가져와서 DB에 있는 값인지 확인하고 결과(JSON)를 전달하는 기능
    	Map<String, Boolean> map = new HashMap<>();
    	String userId = request.getParameter("userId");
    	
    	System.out.println("UserId : " + userId);
    	
    	map.put("duplicate", service.isDuplicateID(userId));
    	
    	response.setContentType("application/json; charset=UTF-8");
    	
    	new Gson().toJson(map, response.getWriter());
	}

}
