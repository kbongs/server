package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService service = new MemberService();

    public UpdateServlet() {
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. 로그인 된 사용자인지 체크
    	HttpSession session = request.getSession(false); 
    	Member loginMember = session != null ? (Member) session.getAttribute("loginMember") : null;
    	Member member = null;
    	String hobby = null;
    	int result = 0;
    	
    	if(loginMember != null) {
    		// 2. 사용자가 수정한 내용을 가지고 Member 객체를 생성
    		member = new Member();
    		
    		member.setNo(loginMember.getNo());
    		member.setId(request.getParameter("userId"));
    		member.setName(request.getParameter("userName"));
    		member.setPhone(request.getParameter("phone"));
    		member.setEmail(request.getParameter("email"));
    		member.setAddress(request.getParameter("address"));
    		
    		hobby = request.getParameterValues("hobby") != null 
    				? String.join(",", request.getParameterValues("hobby")) : null;
    		
    		member.setHobby(hobby);
    		
    		// 3. 회원 정보 수정
    		result = service.save(member);
    		
    		if(result > 0) {
    			// 세션을 갱신한다.
    			session.setAttribute("loginMember", service.findMemberById(loginMember.getId()));
    		
        		request.setAttribute("msg", "회원 정보 수정이 완료되었습니다.");
    			request.setAttribute("location", "/member/myPage");
    		} else {
        		request.setAttribute("msg", "회원 정보 수정에 실패하였습니다.");
    			request.setAttribute("location", "/member/myPage");
    		}
    	} else {
    		request.setAttribute("msg", "로그인 후 수정해 주세요.");
			request.setAttribute("location", "/");
    	}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}
