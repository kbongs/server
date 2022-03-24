package com.kh.ajax.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jsAjax.do")
public class JsAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JsAjaxServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name : " + name + ", age : " + age);
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter()
				.append("서버에서 전송한 값<br>")
				.append("name : " + name + ", age : " + age);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	
		doGet(request, response);
	}
}
