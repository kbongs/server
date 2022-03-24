package com.kh.el.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Person;

@WebServlet("/el.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ELServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 서블릿에서 request, session, application 객체를 가져와서 
    	// 데이터를 setAttribute()에 담아서 el.jsp에 전달
    	HttpSession session = request.getSession();
    	ServletContext application = request.getServletContext();    	
    	
    	// Request Scope에 데이터를 저장
    	request.setAttribute("classRoom", "R 강의장");
    	request.setAttribute("student", new Person("홍길동", 20, '남'));
    	request.setAttribute("scope", "Request 영역");
    	
    	// Session Scope에 데이터를 저장
    	session.setAttribute("academy", "KH 정보교육원");
    	session.setAttribute("teacher", new Person("문인수", 20, '남'));
    	session.setAttribute("scope", "Session 영역");
    	
    	// Application Scope에 데이터를 저장
    	application.setAttribute("scope", "Application 영역");    	
    	
		request.getRequestDispatcher("views/el/el.jsp").forward(request, response);
	}
}
