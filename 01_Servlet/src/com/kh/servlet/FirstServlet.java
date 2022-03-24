package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 서버에서 서블릿을 실행시키는 방법
 * 1. 서블릿 클래스를 작성한다.
 * 	 - javax.servlet.http.HttpServlet를 상속하는 클래스를 생성한다.
 *   - doGet(), doPost() 메소드를 재 정의한다.
 * 2. 서블릿 등록 및 URL을 매핑한다.
 *   - web.xml에 작성한 서블릿을 등록 및 URL을 매핑한다.
 *   - @WebServlet으로 서블릿을 등록 및 URL을 매핑한다.
 */

public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 204599706914368718L;
	
	public FirstServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식의 요청에 응답할 로직을 구현하면 된다.
		System.out.println("사용자로부터 GET 요청을 받음.");

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>우리가 만든 첫 번째 서블릿이 반환한 내용</h1>");
		out.write("</body>");
		out.write("</html>");
	}	
}
