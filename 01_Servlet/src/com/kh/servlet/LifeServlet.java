package com.kh.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life.do")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LifeServlet() {
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
    	System.out.println("init() 메소드 실행");
	}
    
    @Override
	public void destroy() {
    	System.out.println("destroy() 메소드 실행");
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메소드 실행 : 요청 방식에 따라 doGet() 또는 doPost() 메소드 실행");
		
		super.service(request, response);
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet() 메소드 실행");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doPost() 메소드 실행");
	}
}
