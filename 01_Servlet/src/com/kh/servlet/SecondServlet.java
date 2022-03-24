package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션으로 servlet 등록 및 URL 매핑
//@WebServlet("/second.do")
@WebServlet(name = "second", urlPatterns = "/second.do")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>우리가 만든 두 번째 서블릿이 반환한 내용</h1>");
		out.write("</body>");
		out.write("</html>");
	}

}
